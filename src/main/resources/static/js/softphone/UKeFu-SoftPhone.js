var ws_address = "cc.ketianyun.com" , wss_port = "7443" ;	//服务器地址 ， FreeSwitch //112.74.54.80
$(document).ready(function(){
	
	$(document).on("click" , '[data-toggle="soft-function"]' , function(e){
		if($(this).closest(".disabled").length == 0){
			var name = $(this).data("action");
			if(name == "login"){
				uKeFuSoftPhone.input();
			}else if(name == "logout"){
				uKeFuSoftPhone.logout();
			}else if(name == "ready"){
				uKeFuSoftPhone.ready();
			}else if(name == "notready"){
				uKeFuSoftPhone.notready();
			}else if(name == "answer"){
				uKeFuSoftPhone.answer();
			}else if(name == "hungup"){
				uKeFuSoftPhone.hungup();
			}else if(name == "hold"){
				uKeFuSoftPhone.hold();
			}else if(name == "unhold"){
				uKeFuSoftPhone.unhold();
			}
		}		
	});
	var ondial = false ;
	$('#softphone-makecall').click(function(){
		if($(this).closest(".disabled").length == 0){
			$('#dialpad').show();
		}
	}) ;
	$('#dialpad .number').on("mousedown" , function(e){
		$(this).css("background-color" , "#1E90FF") ;
	}).on("mouseup" , function(e){
		$(this).css("background-color" , "#FFFFFF") ;
	}).on("click" , function(e){
		$("#dialpad-input").val($("#dialpad-input").val() + $(this).attr("id"));
	});

	$('#dialpad .dialnum .kfont').on("click", function (e) {
        $("#dialpad-input").val($("#dialpad-input").val().substr(0, $("#dialpad-input").val().length - 1));
    });

	$("#makecall").on("click" , function(){
		if(new RegExp(/^(0\d{2,3}-{0,1}\d{5,8}(-{0,1}\d{3,5}){0,1})|(((13[0-9])|(15([0-3]|[5-9]))|(18[0-9]))\d{8})|(1[0-9]{3})$/).test($('#dialpad-input').val())){
			uKeFuSoftPhone.invite($('#dialpad-input').val());
			$('#dialpad-input').val("") ;
			$('#dialpad').hide();
		}else{
			layer.msg("无效的号码，请重新输入");
		}
	});
	$('#dialpad').hover(function(){
		ondial = true ;
	}, function(){
		ondial = false ;
		setTimeout(function(){
			if(ondial == false){
				$('#dialpad').hide();
			}
		} , 1000);
	});
});
var softPhoneUA , currentSession , mediaStream;

var uKeFuSoftPhone = {
	getOptions : function(){
		var options = {
			media: {
				constraints: {
					audio: true,
					video: false
				},
				render: {
					remote: document.getElementById('remoteAudio'),
					local: document.getElementById('localAudio')
				},
				stunServers: ["stun:stun.freeswitch.org"]
			},
			//stunServers: ["stun:stun.freeswitch.org"]
		}
		return options ;
	},
	input : function(){
        uKeFuSoftPhone.login('1001' , 'P@ss2017');
	},
	login : function(extno , extpass){
        var config = {
            uri: extno+'@'+ws_address,
            wsServers: 'wss://'+ws_address+':'+wss_port,
            authorizationUser: extno,
            password: extpass,
            allowLegacyNotifications:true,
            autostart:true,
            register: false,
			iceCheckingTimeout: 500
        };
        softPhoneUA = new SIP.UA(config);
        softPhoneUA.on('invite', function (session) {
        	document.getElementById("ringAudio").play();
            uKeFuSoftPhone.status.callIn();
            currentSession = session ;
            uKeFuSoftPhone.sessionEvent(session);

        })
        softPhoneUA.on('connecting', function (args) {
            console.log("connecting");
        });
        softPhoneUA.on('connected', function () {
            if(softPhoneUA.isRegistered()){
                uKeFuSoftPhone.status.ready();
            }else{
                uKeFuSoftPhone.status.notready();
            }
        });
        softPhoneUA.on('unregistered', function (response, cause) {
            uKeFuSoftPhone.status.notready();
        });
        softPhoneUA.on('registered', function () {
            uKeFuSoftPhone.status.ready();
        })
        softPhoneUA.on('disconnected', function () {
            uKeFuSoftPhone.status.logout();
        })
        uKeFuSoftPhone.status.login();
        var mediaConstraints = {
            audio: true,
            video: true
        };
	},
	ready:function(){
		softPhoneUA.register({register:true});
	},
	invite:function(pnumber){
		currentSession = softPhoneUA.invite(pnumber+"@"+ws_address , uKeFuSoftPhone.getOptions());
		uKeFuSoftPhone.sessionEvent(currentSession);
		uKeFuSoftPhone.status.callOut();
	},
	logout:function(){
		softPhoneUA.stop({register:true});
	},
	answer:function(){
		if(currentSession){

			currentSession.accept(uKeFuSoftPhone.getOptions());
		}
	},
	hungup:function(){
		if(currentSession){
			if(currentSession.hasAnswer){
				currentSession.bye();
			}else if(currentSession.isCanceled == false){
				currentSession.cancel();
			}else{
				currentSession.reject();
			}
		}
	},
	hold:function(){
		if(currentSession && currentSession.hasAnswer){
			currentSession.hold();
		}
	},
	unhold:function(){
		if(currentSession && currentSession.hasAnswer){
			currentSession.unhold();
		}
	},
	notready:function(){
		softPhoneUA.unregister();
	},
	sessionEvent:function(session){
		session.on("rejected" , function (response, cause){
            document.getElementById("ringAudio").pause();
			uKeFuSoftPhone.status.hungup();
		});
		session.on("bye" , function (response, cause){
			uKeFuSoftPhone.status.hungup();
		});
		session.on("hold" , function (response, cause){
			uKeFuSoftPhone.status.hold();
		});
		session.on("unhold" , function (response, cause){
			uKeFuSoftPhone.status.unhold();
		});
		session.on("accepted" , function (response, cause){
            document.getElementById("ringAudio").pause();
			uKeFuSoftPhone.status.accepted();
		});
		session.on("cancel" , function (response, cause){
			uKeFuSoftPhone.status.hungup();
		});
		uKeFuSoftPhone.status.initCallStatus(session) ;
	},
	status : {
		login:function(){
			$('.soft-function,.status').removeClass("disabled");	
			$('#softphone-answer').addClass("disabled");
			$('#softphone-hungup').addClass("disabled");
			
			$('#softphone-status .hold').addClass("disabled").show();
			$('#softphone-status .unhold').addClass("disabled").hide();

			$('#softphone-trans').addClass("disabled");
			$('#softphone-makecall').addClass("disabled");

			$('#ukefu_account .login').hide();
			$('#ukefu_account .logout').show();

			$('#softphone-status .ready').removeClass("disabled").show();
			$('#softphone-status .notready').addClass("disabled").hide();
		},
		ready : function(){
			$('.soft-function,.status').removeClass("disabled");	
			$('#softphone-answer').addClass("disabled");
			$('#softphone-hungup').addClass("disabled");
			
			$('#softphone-status .hold').addClass("disabled").show();
			$('#softphone-status .unhold').addClass("disabled").hide();

			$('#softphone-trans').addClass("disabled");
			$('#softphone-makecall').removeClass("disabled");

			$('#ukefu_account .login').hide();
			$('#ukefu_account .logout').show();
			$('#softphone-status .ready').addClass("disabled").hide();
			$('#softphone-status .notready').removeClass("disabled").addClass("green").show();
		},
		notready : function(){
			$('.soft-function,.status').removeClass("disabled");	
			$('#softphone-answer').addClass("disabled");
			$('#softphone-hungup').addClass("disabled");

			$('#softphone-status .hold').addClass("disabled").show();
			$('#softphone-status .unhold').addClass("disabled").hide();

			$('#softphone-trans').addClass("disabled");
			$('#softphone-makecall').addClass("disabled");

			$('#ukefu_account .login').hide();
			$('#ukefu_account .logout').show();

			$('#softphone-status .ready').removeClass("disabled").show();
			$('#softphone-status .notready').addClass("disabled").hide();

		},
		callIn : function(){
			$('.soft-function,.status').removeClass("disabled");	
			$('#softphone-answer').removeClass("disabled");
			$('#softphone-hungup').removeClass("disabled");
			
			$('#softphone-status .hold').addClass("disabled").show();;
			$('#softphone-status .unhold').addClass("disabled").hide();

			$('#softphone-trans').addClass("disabled");
			$('#softphone-makecall').addClass("disabled");

			$('#ukefu_account .login').hide();
			$('#ukefu_account .logout').show();

			$('#softphone-status .ready').addClass("disabled").hide();
			$('#softphone-status .notready').addClass("disabled").show();
		},
		callOut : function(){
			$('.soft-function,.status').removeClass("disabled");	
			$('#softphone-answer').addClass("disabled");
			$('#softphone-hungup').removeClass("disabled");
			
			$('#softphone-status .hold').addClass("disabled").show();;
			$('#softphone-status .unhold').addClass("disabled").hide();

			$('#softphone-trans').addClass("disabled");
			$('#softphone-makecall').addClass("disabled");

			$('#ukefu_account .login').hide();
			$('#ukefu_account .logout').show();

			$('#softphone-status .ready').addClass("disabled").hide();
			$('#softphone-status .notready').addClass("disabled").show();
		},
		hungup : function(){
			$('.soft-function,.status').removeClass("disabled");	
			$('#softphone-answer').addClass("disabled");
			$('#softphone-hungup').addClass("disabled");
			
			$('#softphone-status .hold').addClass("disabled").show();;
			$('#softphone-status .unhold').addClass("disabled").hide();

			$('#softphone-trans').addClass("disabled");
			$('#softphone-makecall').removeClass("disabled");

			$('#ukefu_account .login').hide();
			$('#ukefu_account .logout').show();
			
			$('#softphone-status .ready').addClass("disabled").hide();
			$('#softphone-status .notready').removeClass("disabled").show();
		},
		accepted : function (response, cause){
			$('.soft-function,.status').removeClass("disabled");	
			$('#softphone-answer').addClass("disabled");
			$('#softphone-hungup').removeClass("disabled");
			
			$('#softphone-status .hold').removeClass("disabled").show();
			$('#softphone-status .unhold').addClass("disabled").hide();

			$('#softphone-trans').removeClass("disabled");
			$('#softphone-makecall').addClass("disabled");

			$('#ukefu_account .login').hide();
			$('#ukefu_account .logout').show();

			$('#softphone-status .ready').addClass("disabled").hide();
			$('#softphone-status .notready').addClass("disabled").show();
		},
		hold : function (){
			$('.soft-function,.status').removeClass("disabled");	
			$('#softphone-answer').addClass("disabled");
			$('#softphone-hungup').addClass("disabled");
			
			$('#softphone-status .hold').addClass("disabled").hide();
			$('#softphone-status .unhold').removeClass("disabled").show();

			$('#softphone-trans').addClass("disabled");
			$('#softphone-makecall').removeClass("disabled");

			$('#ukefu_account .login').hide();
			$('#ukefu_account .logout').show();

			$('#softphone-status .ready').addClass("disabled").hide();
			$('#softphone-status .notready').addClass("disabled").show();
		},
		unhold : function (){
			$('.soft-function,.status').removeClass("disabled");	
			$('#softphone-answer').addClass("disabled");
			$('#softphone-hungup').removeClass("disabled");
			
			$('#softphone-status .hold').removeClass("disabled").show();
			$('#softphone-status .unhold').addClass("disabled").hide();

			$('#softphone-trans').removeClass("disabled");
			$('#softphone-makecall').addClass("disabled");

			$('#ukefu_account .login').hide();
			$('#ukefu_account .logout').show();

			$('#softphone-status .ready').addClass("disabled").hide();
			$('#softphone-status .notready').addClass("disabled").show();
		},
		logout : function (){	
			$('.status').addClass("disabled");	
			$('#softphone-answer').addClass("disabled");
			$('#softphone-hungup').addClass("disabled");
			
			$('#softphone-status .hold').addClass("disabled").show();
			$('#softphone-status .unhold').addClass("disabled").hide();

			$('#softphone-trans').addClass("disabled");
			$('#softphone-makecall').addClass("disabled");

			$('#softphone-status .ready').addClass("disabled").show();
			$('#softphone-status .notready').addClass("disabled").hide();

			$('#ukefu_account .login').removeClass("disabled").show();
			$('#ukefu_account .logout').addClass("disabled").hide();
		},
		initCallStatus:function(session , called){
			$('#caller .number').text(session.request.from.uri.user);
			if(called){
				$('#called .number').text(called);
			}
		}
	}
	
}
function getUserMediaSuccess (stream) {
	console.log('getUserMedia succeeded', stream)
	mediaStream = stream;
}

function getUserMediaFailure (e) {
	console.error('getUserMedia failed:', e);
}

