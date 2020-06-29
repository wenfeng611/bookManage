/**
 * Created by Administrator on 2017/10/26.
 */
var agentNum;
$(document).ready(function () {
    const html = "<div class=\"header header-ukefu\">\n" +
        "<div class=\"ukefu-softphone-head\">\n" +
        "<div class=\"ukefu-softphone\">\n" +
        "<div class=\"softphone-stream\" style=\"display:none;\">\n" +
        "<audio src=\"wav/ring.wav\" loop id=\"ringAudio\"></audio>\n" +
        "<audio  id=\"remoteAudio\"></audio >\n" +
        "<audio  id=\"localAudio\" muted=\"muted\"></audio>\n" +
        "</div>\n" +
        "<div class=\"status disabled\">\n" +
        "<div class=\"text\" id=\"caller\">主叫号码：<span class=\"number\"></span></div>\n" +
        "<div class=\"text\" id=\"called\">被叫号码：<span class=\"number\"></span></div>\n" +
        "</div>\n" +
        "<div class=\"soft-function disabled\" id=\"softphone-status\">\n" +
        "<div class=\"soft-function ready\" data-toggle=\"soft-function\" data-action=\"ready\">\n" +
        "<div class=\"icon\"><i class=\"kfont\">&#xe602;</i></div>\n" +
        "<div class=\"text\">就绪</div>\n" +
        "</div>\n" +
        "<div class=\"soft-function notready\" style=\"display:none;\" data-toggle=\"soft-function\" data-action=\"notready\">\n" +
        "<div class=\"icon\"><i class=\"kfont\">&#xe689;</i></div>\n" +
        "<div class=\"text\">未就绪</div>\n" +
        "</div>\n" +
        "</div>\n" +
        "\n" +
        "<div class=\"soft-function disabled\" id=\"softphone-busy\" data-toggle=\"soft-function\" data-action=\"busy\">\n" +
        "<div class=\"icon\"><i class=\"kfont\">&#xe698;</i></div>\n" +
        "<div class=\"text\">置忙</div>\n" +
        "</div>\n" +
        "\n" +
        "<div class=\"soft-function disabled\" id=\"softphone-answer\" data-toggle=\"soft-function\" data-action=\"answer\">\n" +
        "<div class=\"icon\"><i class=\"kfont\">&#xe698;</i></div>\n" +
        "<div class=\"text\">接听</div>\n" +
        "</div>\n" +
        "<div class=\"soft-function disabled\" id=\"softphone-hungup\" data-toggle=\"soft-function\" data-action=\"hungup\">\n" +
        "<div class=\"icon\"><i class=\"kfont\">&#xe60e;</i></div>\n" +
        "<div class=\"text\">挂断</div>\n" +
        "</div>\n" +
        "\n" +
        "<div class=\"soft-function disabled diafunction\" id=\"softphone-makecall\">\n" +
        "<div class=\"icon\"><i class=\"kfont\">&#xe670;</i></div>\n" +
        "<div class=\"text\">拨打</div>\n" +
        "<div class=\"dialpad\" id=\"dialpad\">\n" +
        "<div class=\"dialnum\">\n" +
        "<input class=\"dialpad-input\" type=\"text\" id=\"dialpad-input\" placeholder=\"按拨号盘或者键盘输入电话号码\" value=\"\">\n" +
        "<i class=\"kfont\">&#xe675;</i>\n" +
        "</div>\n" +
        "<button class=\"number\" id=\"1\">1</button>\n" +
        "<button class=\"number\" id=\"2\">2</button>\n" +
        "<button class=\"number\" id=\"3\">3</button>\n" +
        "<button class=\"number\" id=\"4\">4</button>\n" +
        "<button class=\"number\" id=\"5\">5</button>\n" +
        "<button class=\"number\" id=\"6\">6</button>\n" +
        "<button class=\"number\" id=\"7\">7</button>\n" +
        "<button class=\"number\" id=\"8\">8</button>\n" +
        "<button class=\"number\" id=\"9\">9</button>\n" +
        "<button class=\"number\" id=\"*\">*</button>\n" +
        "<button class=\"number\" id=\"0\">0</button>\n" +
        "<button class=\"number\" id=\"#\">#</button>\n" +
        "\n" +
        "<button id=\"makecall\" class=\"call\"><i class=\"kfont\">&#xe61f;</i></button>\n" +
        "</div>\n" +
        "</div>\n" +
        "<div class=\"soft-function disabled\" id=\"softphone-status\">\n" +
        "<div class=\"soft-function hold\" data-toggle=\"soft-function\" data-action=\"hold\">\n" +
        "<div class=\"icon\"><i class=\"kfont\">&#xe647;</i></div>\n" +
        "<div class=\"text\">保持</div>\n" +
        "</div>\n" +
        "<div class=\"soft-function unhold\" data-toggle=\"soft-function\" data-action=\"unhold\" style=\"display:none;\">\n" +
        "<div class=\"icon\"><i class=\"kfont\">&#xe605;</i></div>\n" +
        "<div class=\"text\">取回</div>\n" +
        "</div>\n" +
        "</div>\n" +
        "<div class=\"soft-function disabled\" id=\"softphone-dtmf\">\n" +
        "<div class=\"icon\" style=\"margin-top:2px;\"><i class=\"iconfont\">&#xe6a9;</i></div>\n" +
        "<div class=\"text\">DTMF</div>\n" +
        "<div class=\"dtmf-dialpad\" id=\"dtmf-dialpad\">\n" +
        "<div class=\"dialnum\">\n" +
        "<input class=\"dtmf-dialpad-input\" type=\"text\" id=\"dtmf-dialpad-input\" value=\"\">\n" +
        "</div>\n" +
        "<button class=\"number\" id=\"1\">1</button>\n" +
        "<button class=\"number\" id=\"2\">2</button>\n" +
        "<button class=\"number\" id=\"3\">3</button>\n" +
        "<button class=\"number\" id=\"4\">4</button>\n" +
        "<button class=\"number\" id=\"5\">5</button>\n" +
        "<button class=\"number\" id=\"6\">6</button>\n" +
        "<button class=\"number\" id=\"7\">7</button>\n" +
        "<button class=\"number\" id=\"8\">8</button>\n" +
        "<button class=\"number\" id=\"9\">9</button>\n" +
        "<button class=\"number\" id=\"*\">*</button>\n" +
        "<button class=\"number\" id=\"0\">0</button>\n" +
        "<button class=\"number\" id=\"#\">#</button>\n" +
        "</div>\n" +
        "</div>\n" +
        /* "<div class=\"soft-function disabled\" id=\"softphone-trans\" data-toggle=\"soft-function\" data-action=\"trans\">\n" +
        "<div class=\"icon\"><i class=\"kfont\">&#xe663;</i></div>\n" +
        "<div class=\"text\">转接</div>\n" +
        "</div>\n" +*/
        "<div class=\"soft-function\" id=\"ukefu_account\">\n" +
        "<div class=\"soft-function login\" data-toggle=\"soft-function\" data-action=\"login\">\n" +
        "<div class=\"icon\"><i class=\"kfont\">&#xe61f;</i></div>\n" +
        "<div class=\"text\">登录</div>\n" +
        "</div>\n" +
        "<div class=\"soft-function logout\" style=\"display:none;\" data-toggle=\"soft-function\" data-action=\"logout\">\n" +
        "<div class=\"icon\"><i class=\"kfont\">&#xe606;</i></div>\n" +
        "<div class=\"text\">登出</div>\n" +
        "</div>\n" +
        "</div>\n" +
        "<div class=\"status disabled\">\n" +
        "<div class=\"text-localNum\" id=\"localNum\">登录号码: <span class=\"number\"></span></div>\n" +
        "</div>\n" +
        "<audio src=\"\" loop id=\"ring_audio\">您的浏览器不支持audio标签</audio>\n" +
        "</div>\n" +
        "</div>\n" +
        "</div>";
    $('#agentBar').html(html);

    $(document).on("click", '[data-toggle="soft-function"]', function (e) {
        if ($(this).closest(".disabled").length == 0) {
            var name = $(this).data("action");
            if (name == "login") {
                CallHelper.register();
            } else if (name == "logout") {
                CallHelper.unregister();
            } else if (name == "ready") {
                CallHelper.ready();
            } else if (name == "notready") {
                CallHelper.notready();
            } else if (name == "busy") {
                CallHelper.busy();
            } else if (name == "answer") {
                CallHelper.answer();
            } else if (name == "hungup") {
                CallHelper.hangup();
            } else if (name == "hold") {
                CallHelper.hold();
            } else if (name == "unhold") {
                CallHelper.unhold();
            }
        }
    });


    var dtmf_ondial = false;
    $('#softphone-dtmf').click(function () {
        if ($(this).closest(".disabled").length == 0) {
            $('#dtmf-dialpad').show();
        }
    });
    $('#dtmf-dialpad .number').on("mousedown", function (e) {
        $(this).css("background-color", "#1E90FF");
    }).on("mouseup", function (e) {
        $(this).css("background-color", "#FFFFFF");
    }).on("click", function (e) {
        CallHelper.dtmf($(this).attr("id"));
        $("#dtmf-dialpad-input").val($("#dtmf-dialpad-input").val() + $(this).attr("id"));
    });
    $('#dtmf-dialpad').hover(function () {
        dtmf_ondial = true;
    }, function () {
        dtmf_ondial = false;
        setTimeout(function () {
            if (dtmf_ondial == false) {
                $('#dtmf-dialpad').hide();
                $("#dtmf-dialpad-input").val('');
            }
        }, 1000);
    });

    var ondial = false;
    $('#softphone-makecall').click(function () {
        if ($(this).closest(".disabled").length == 0) {
            $('#dialpad').show();
            $("#dialpad-input").focus();
        }
    });
    $('#dialpad .number').on("mousedown", function (e) {
        $(this).css("background-color", "#1E90FF");
    }).on("mouseup", function (e) {
        $(this).css("background-color", "#FFFFFF");
    }).on("click", function (e) {
        $("#dialpad-input").val($("#dialpad-input").val() + $(this).attr("id"));
    });

    $('#dialpad .dialnum .kfont').on("click", function (e) {
        $("#dialpad-input").val($("#dialpad-input").val().substr(0, $("#dialpad-input").val().length - 1));
    });

    $("#makecall").on("click", function () {
        if (new RegExp(/^(\d{3}-{0,1}\d{8}|\d{4}-{0,1}\d{7,8}|1{0,1}\d{10}|10086|10010|10000)$/).test($('#dialpad-input').val())) {
            //var outNum = '${outCode}'+$('#dialpad-input').val();
            var outNum = $('#dialpad-input').val();
            if ($('#dialpad-input').val().length < 8) {
                CallHelper.invite($('#dialpad-input').val())
            } else {
                CallHelper.invite(outNum)
            };
            $('#dialpad-input').val("");
            $('#dialpad').hide();
        } else {
            layer.msg("无效的号码，请重新输入");
        }
    });
    $('#dialpad').hover(function () {
        ondial = true;
    }, function () {
        ondial = false;
        setTimeout(function () {
            if (ondial == false) {
                $('#dialpad').hide();
            }
        }, 1000);
    });
    initPhone(window.kefuInfo["token"]);
});

function initPhone(token) {
    const config = {
/*        url: 'http://localhost:6081/agentsocket/getall',
        agentbarUrl: 'http://localhost:6789/agentbar',
        wss_address: '10.10.10.238',
        wss_port: '5066',
        proto: 'ws',*/
        url: 'https://cc-test.ketianyun.com:6082/agentsocket/getall',
        agentbarUrl: 'https://cc-test.ketianyun.com:443/agentbar',
        wss_address: 'cc-test.ketianyun.com',
        wss_port: '10443',
        proto: 'wss',
        token: token,
        debug: true,
        isAutoAnswer: true,
        stateListenerCallBack: stateCallback
    };
    CallHelper.init(config, initCallback);
}

/**
 * 初始化方法回调是否成功
 */
function initCallback(data){
    console.log(data);
    if(data.successChange){
        //显示本机号码
        Softphone.status.login(data.data.agentnumber);
        agentNum = data.data.agentnumber;
        //电话条ready状态变更
        //CallHelper.ready();
    }
}

function stateCallback(data) {
    console.log('stateCallback listener is : ' + data.msg);

    if(data.msg === "READY"){
        Softphone.status.ready();
    }else if(data.msg === "NOTREADY"){
        Softphone.status.notready();
    }else if(data.msg === "BUSY"){
        Softphone.status.busy();
    }else if(data.msg === "RINGING"){
        Softphone.status.callIn(data.data.phoneNum, agentNum);
        document.getElementById("ringAudio").play();
        if(window.kefuFunc&&window.kefuFunc.onRing){
            window.kefuFunc.onRing(data.data);
        }
    }else if(data.msg === "ANSWERED"){
        document.getElementById("ringAudio").pause();
        Softphone.status.accepted();
    }else if(data.msg === "HANGUP"){
        document.getElementById("ringAudio").pause();
        Softphone.status.hangup();
    }else if(data.msg === "HOLD"){
        Softphone.status.hold();
    }else if(data.msg === "LOGOUT"){
        Softphone.status.logout();
    }

}

var Softphone = {
    //状态变更
    status: {
        //注册成功
        login: function (account) {
            $('.soft-function,.status').removeClass("disabled");

            $('#softphone-busy').addClass("disabled");

            $('#softphone-answer').addClass("disabled");
            $('#softphone-hungup').addClass("disabled");

            $('#softphone-status .hold').addClass("disabled").show();
            $('#softphone-status .unhold').addClass("disabled").hide();

            $('#softphone-trans').addClass("disabled");
            $('#softphone-makecall').addClass("disabled");

            $('#softphone-dtmf').addClass("disabled");

            $('#ukefu_account .login').hide();
            $('#ukefu_account .logout').show();

            $('#softphone-status .ready').removeClass("disabled").show();
            $('#softphone-status .notready').addClass("disabled").hide();

            $('#localNum .number').text(account);
        },

        ready: function () {
            $('.soft-function,.status').removeClass("disabled");

            $('#softphone-busy').removeClass("disabled");

            $('#softphone-answer').addClass("disabled");
            $('#softphone-hungup').addClass("disabled");

            $('#softphone-status .hold').addClass("disabled").show();
            $('#softphone-status .unhold').addClass("disabled").hide();

            $('#softphone-trans').addClass("disabled");
            $('#softphone-makecall').removeClass("disabled");

            $('#softphone-dtmf').addClass("disabled");

            $('#ukefu_account .login').hide();
            $('#ukefu_account .logout').show();
            $('#softphone-status .ready').addClass("disabled").hide();
            $('#softphone-status .notready').removeClass("disabled").addClass("green").show();
        },

        notready: function () {
            $('.soft-function,.status').removeClass("disabled");

            $('#softphone-busy').addClass("disabled");

            $('#softphone-answer').addClass("disabled");
            $('#softphone-hungup').addClass("disabled");

            $('#softphone-status .hold').addClass("disabled").show();
            $('#softphone-status .unhold').addClass("disabled").hide();

            $('#softphone-trans').addClass("disabled");
            $('#softphone-makecall').addClass("disabled");

            $('#softphone-dtmf').addClass("disabled");

            $('#ukefu_account .login').hide();
            $('#ukefu_account .logout').show();

            $('#softphone-status .ready').removeClass("disabled").show();
            $('#softphone-status .notready').addClass("disabled").hide();
        },

        busy: function () {
            $('.soft-function,.status').removeClass("disabled");

            $('#softphone-busy').addClass("disabled");

            $('#softphone-answer').addClass("disabled");
            $('#softphone-hungup').addClass("disabled");

            $('#softphone-status .hold').addClass("disabled").show();
            $('#softphone-status .unhold').addClass("disabled").hide();

            $('#softphone-trans').addClass("disabled");
            $('#softphone-makecall').addClass("disabled");

            $('#softphone-dtmf').addClass("disabled");

            $('#ukefu_account .login').hide();
            $('#ukefu_account .logout').show();

            $('#softphone-status .ready').removeClass("disabled").show();
            $('#softphone-status .notready').addClass("disabled").hide();
        },

        accepted: function () {
            $('.soft-function,.status').removeClass("disabled");

            $('#softphone-busy').addClass("disabled");

            $('#softphone-answer').addClass("disabled");
            $('#softphone-hungup').removeClass("disabled");

            $('#softphone-status .hold').removeClass("disabled").show();
            $('#softphone-status .unhold').addClass("disabled").hide();

            $('#softphone-trans').removeClass("disabled");
            $('#softphone-makecall').addClass("disabled");

            $('#softphone-dtmf').removeClass("disabled");

            $('#ukefu_account .login').hide();
            $('#ukefu_account .logout').show();

            $('#softphone-status .ready').addClass("disabled").hide();
            $('#softphone-status .notready').addClass("disabled").show();
        },

        hangup: function () {
            $('.soft-function,.status').removeClass("disabled");

            $('#softphone-busy').removeClass("disabled");

            $('#softphone-answer').addClass("disabled");
            $('#softphone-hungup').addClass("disabled");

            $('#softphone-status .hold').addClass("disabled").show();
            $('#softphone-status .unhold').addClass("disabled").hide();

            $('#softphone-trans').addClass("disabled");
            $('#softphone-makecall').removeClass("disabled");

            $('#softphone-dtmf').addClass("disabled");

            $('#ukefu_account .login').hide();
            $('#ukefu_account .logout').show();

            $('#softphone-status .ready').addClass("disabled").hide();
            $('#softphone-status .notready').removeClass("disabled").show();

            $('#caller .number').text('');
            $('#called .number').text('');
        },
        
        hold: function () {
            $('.soft-function,.status').removeClass("disabled");

            $('#softphone-busy').addClass("disabled");
            $('#softphone-answer').addClass("disabled");
            $('#softphone-hungup').addClass("disabled");

            $('#softphone-status .hold').addClass("disabled").hide();
            $('#softphone-status .unhold').removeClass("disabled").show();

            $('#softphone-trans').addClass("disabled");
            $('#softphone-makecall').addClass("disabled");

            $('#softphone-dtmf').addClass("disabled");

            $('#ukefu_account .login').hide();
            $('#ukefu_account .logout').show();

            $('#softphone-status .ready').addClass("disabled").hide();
            $('#softphone-status .notready').addClass("disabled").show();
        },

        unhold: function () {
            $('.soft-function,.status').removeClass("disabled");

            $('#softphone-busy').addClass("disabled");
            $('#softphone-answer').addClass("disabled");
            $('#softphone-hungup').removeClass("disabled");

            $('#softphone-status .hold').removeClass("disabled").show();
            $('#softphone-status .unhold').addClass("disabled").hide();

            $('#softphone-trans').removeClass("disabled");
            $('#softphone-makecall').addClass("disabled");

            $('#softphone-dtmf').removeClass("disabled");

            $('#ukefu_account .login').hide();
            $('#ukefu_account .logout').show();

            $('#softphone-status .ready').addClass("disabled").hide();
            $('#softphone-status .notready').addClass("disabled").show();
        },

        logout: function () {
            $('.status').addClass("disabled");
            $('#softphone-answer').addClass("disabled");
            $('#softphone-hungup').addClass("disabled");

            $('#softphone-busy').addClass("disabled");

            $('#softphone-status .hold').addClass("disabled").show();
            $('#softphone-status .unhold').addClass("disabled").hide();

            $('#softphone-trans').addClass("disabled");
            $('#softphone-makecall').addClass("disabled");

            $('#softphone-dtmf').addClass("disabled");

            $('#softphone-status .ready').addClass("disabled").show();
            $('#softphone-status .notready').addClass("disabled").hide();

            $('#ukefu_account .login').removeClass("disabled").show();
            $('#ukefu_account .logout').addClass("disabled").hide();

            $('#localNum .number').text('');
        },

        callIn: function (caller, callee) {
            $('.soft-function,.status').removeClass("disabled");

            $('#softphone-busy').addClass("disabled");
            $('#softphone-answer').removeClass("disabled");
            $('#softphone-hungup').removeClass("disabled");

            $('#softphone-status .hold').addClass("disabled").show();
            $('#softphone-status .unhold').addClass("disabled").hide();

            $('#softphone-trans').addClass("disabled");
            $('#softphone-makecall').addClass("disabled");

            $('#softphone-dtmf').addClass("disabled");

            $('#ukefu_account .login').hide();
            $('#ukefu_account .logout').show();

            $('#softphone-status .ready').addClass("disabled").hide();
            $('#softphone-status .notready').addClass("disabled").show();

            $('#caller .number').text(caller);
            $('#called .number').text(callee);
        },

        callOut: function () {
            $('.soft-function,.status').removeClass("disabled");

            $('#softphone-busy').addClass("disabled");
            $('#softphone-answer').addClass("disabled");
            $('#softphone-hungup').removeClass("disabled");

            $('#softphone-status .hold').addClass("disabled").show();
            $('#softphone-status .unhold').addClass("disabled").hide();

            $('#softphone-trans').addClass("disabled");
            $('#softphone-makecall').addClass("disabled");

            $('#softphone-dtmf').addClass("disabled");

            $('#ukefu_account .login').hide();
            $('#ukefu_account .logout').show();

            $('#softphone-status .ready').addClass("disabled").hide();
            $('#softphone-status .notready').addClass("disabled").show();
        },
    }
};


function openPanelMakeCall(phoneNum, isAutoCall) {
    if("READY" === window.localStorage["state"]){
        $('#dialpad').show();
        $('#dialpad-input').val(phoneNum);
        if (isAutoCall) {
            $('#makecall').click();
        }
    }else{
        layer.msg("电话状态尚未就绪, 请就绪后再拨！", {time: 5000});
        console.log("坐席未就绪，无法外呼!");
    }
}