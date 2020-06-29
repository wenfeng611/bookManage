//
// (function(global) {
//     'use strict';
//     if (!global.console) {
//         global.console = {};
//     }
//     var con = global.console;
//     var prop, method;
//     var dummy = function() {};
//     var properties = ['memory'];
//     var methods = ('assert,clear,count,debug,dir,dirxml,error,exception,group,' +
//     'groupCollapsed,groupEnd,info,log,markTimeline,profile,profiles,profileEnd,' +
//     'show,table,time,timeEnd,timeline,timelineEnd,timeStamp,trace,warn').split(',');
//     while (prop = properties.pop()) if (!con[prop]) con[prop] = {};
//     while (method = methods.pop()) if (!con[method]) con[method] = dummy;
//     // Using `this` for web workers & supports Browserify / Webpack.
// })(typeof window === 'undefined' ? this : window);
var editor , words;
if (!window.location.origin) {
    window.location.origin = window.location.protocol + "//" + window.location.hostname + (window.location.port ? ':' + window.location.port: '');
}
KindEditor.ready(function (K) {
    editor = K.create('textarea[name="content"]', {
        autoHeightMode: false,
        width: "100%",
        resizeType: 0,
        themeType: 'simple',
        fontsize: 16,
        loadStyleMode : false,
        newlineTag : "br" ,
        uploadJson : "/im/image/upload.html?userid="+window.config.userid+"&orgi="+window.config.orgi,
        allowFileManager : false,
        allowInsertUpload:false,		//增加的参数，上传图片后是否插入到当前区域
        allowImageRemote:false,
        filterMode:true,
        pluginsPath:window.location.origin+"/assets/plugins/",
        items: ['emoticons',  'image'],
        htmlTags: {img : ['src', 'width', 'height', 'border', 'alt', 'title', 'align', '.width', '.height', '.border'] , br:[]}  ,
        afterChange : function() {
            var count = this.count() ;
            var limitNum = 300;  //设定限制字数
            var pattern = '您还可以输入' + limitNum + '字';
            var strValue = this.html();
            if(count > limitNum) {
                pattern = ('字数超过限制，请适当删除部分内容');
                //超过字数限制自动截取
                strValue = strValue.substring(0,limitNum);
                editor.html(strValue);
            } else {
                //计算剩余字数
                var result = limitNum - this.count();
                pattern = '还可以输入' +  result + '字';
                if(result < 20){
                    document.getElementById('surplus').style.color = "red" ;
                }else{
                    document.getElementById('surplus').style.color = "#000000" ;
                }
            }
            if(this.count("text") == 0){
                strValue= "" ;
            }
            if(words != this.count("text")){
                socket.emit('message', {
                    appid : config.appid,
                    userid:config.userid,
                    type:"writing",
                    session:config.sessionid,
                    orgi:config.orgi,
                    message : strValue
                });
            }
            words = this.count("text") ;
            document.getElementById('surplus').innerHTML = count+"/"+limitNum+" , " + pattern; //输入显示
            ////////
        },
        afterCreate : function() { //设置编辑器创建后执行的回调函数
            var self = this;
            //Enter提交表单
            K.key(self.edit.doc,13,function () {
                self.sync();
                sendMessage();
            });

            // K.ctrl(document, 13, function() {
            //     self.sync();
            //     sendMessage();
            // });
            // K.ctrl(self.edit.doc, 13, function() {
            //     self.sync();
            //     sendMessage();
            // });
        },
        // afterChange:function(e){
        //     console.log(e)
        // }
    });
});
KindEditor.options.cssData = "body { font-size: 15px; font-family:'Microsoft Yahei', 'Helvetica', 'Simsun', 'Arial';}";
var R3Ajax = {
    ajax:function(opt){
        var xhr = this.createXhrObject();
        xhr.onreadystatechange = function(){
            if(xhr.readyState!=4) return ;
            (xhr.status===200 ?
                opt.success(xhr.responseText,xhr.responseXML):
                opt.error(xhr.responseText,xhr.status));
        }
        xhr.open(opt.type,opt.url,true);
        if(opt.type!=='post')
            opt.data=null;
        else
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        opt.data = this.parseQuery(opt.data);
        xhr.send(opt.data);
    },
    post:function(url,success,data){
        var popt = {
            url:url,
            type:'post',
            data:data,
            success:success,
            error:function(data){}
        }
        this.ajax(popt);
    },
    get:function(url,success){
        var gopt = {
            url:url,
            type:'get',
            success:success,
            error:function(){}
        }
        this.ajax(gopt);
    },
    createXhrObject:function(){
        var methods = [
            function(){ return new XMLHttpRequest();},
            function(){ return new ActiveXObject('Msxml2.XMLHTTP');},
            function(){ return new ActiveXObject('Microsoft.XMLHTTP');}
        ];
        for(var i=0;len=methods.length,i<len;i++){
            try{
                methods[i]();
            }catch(e){
                continue;
            }
            this.createXhrObject = methods[i];
            return methods[i]();
        }
        throw new Error('Could not create an XHR object.');
    },
    parseQuery:function(json){
        if(typeof json == 'object'){
            var str = '';
            for(var i in json){
                str += "&"+i+"="+encodeURIComponent(json[i]);
            }
            return str.length==0 ? str : str.substring(1);
        }else{
            return json;
        }
    }
};
Date.prototype.format = function(fmt) {
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt)) {
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    for(var k in o) {
        if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
    return fmt;
}
var R3Helper = {
    resize : function(){
        var height = document.body.offsetHeight ;
        document.getElementById('above').style.height = (height - 194 - 50)+"px" ;
    }
}
window.onbeforeunload = function(){
    return "您确定断开对话？" ;
}
var service_end = false ;
R3Helper.resize();
// 调查问卷
var diaShade=document.getElementById('diaShade');
var dialogWrap=document.getElementById('dialogWrap');
function popup(para) {
    diaShade.style.display=para;
    dialogWrap.style.display=para;
}
document.getElementById('above').scrollTop = document.getElementById('above').scrollHeight  ;	//滚动到 对话内容的 底部
// 参数连接
var hostname = location.hostname;
var socketUrl = config.schema+"://"+hostname+":"+config.port+"/im/user";
var socketParams= {
    userid:config.userid,
    orgi:config.orgi,
    session:config.sessionid,
    appid:config.appid,
    osname:config.osname,
    browser:config.browser,
    skill:config.skill,
    agent:config.agent
};
var socketParamsArray=[];
for (var i in socketParams){
    socketParamsArray.push(i+"="+socketParams[i])
}
socketUrl+="?"+socketParamsArray.join("&");

// console.log(socketUrl);



var socket = io.connect(socketUrl);
socket.on('connect',function(){
    //service.sendRequestMessage();
    //output('<span id="connect-message">'+ new Date().format("yyyy-MM-dd hh:mm:ss") + ' 开始沟通' +'</span>' , 'message connect-message');
})
socket.on("agentstatus",function(data){
    document.getElementById('connect-message').innerHTML=data.message;
})
socket.on("status",function(data){
    output('<span id="connect-message">'+data.message+'</span>' , 'message connect-message');
    if(data.messageType == "end"){
        service_end = true ;
        editor.readonly();
    }
})
socket.on('message', function(data) {
    var chat=document.getElementsByClassName('chatting-left').innerText;
    chat = data.message;
    if(data.messageType == "image"){
        chat = "<img src='"+data.message+"' class='kefu-media-image'>" ;
    }
    if(data.calltype == "in"){
        if(typeof chatUserName != 'undefined') {
            chatUserName = data.nickName;
        }
        output('<div class="chat-right"> <img class="user-img" src="/im/img/user.png" alt=""><div class="chat-message"><label class="time">'+data.createtime+'</label><label  class="user">'+data.nickName+'</label> </div><div class="chatting-right"><i class="arrow arrow'+config.consult_dialog_color+'"></i><div class="chat-content theme'+config.consult_dialog_color+'">'+chat+'</div></div>' , "chat-block");
    }else if(data.calltype == "out"){
        if(typeof chatUserName != 'undefined') {
            chatUserName = data.nickName;
        }
        output('<div class="chat-left"> <img class="user-img" src="'+config.consult_dialog_headimg+'" alt=""><div class="chat-message"><label  class="user">'+data.nickName+'</label><label class="time">'+data.createtime+'</label> </div><div class="chatting-left"><i class="arrow"></i><div class="chat-content">'+chat+'</div></div>' , "chat-block");
    }
});

socket.on('disconnect',function() {
    output('<span id="connect-message">连接坐席失败，在线咨询服务不可用</span>' , 'message connect-message');
});
function sendDisconnect(){
    socket.disconnect();
}
function sendMessage() {
    editor.sync();
    var count = editor.count("text");
    if(count>0 && service_end == false){
        var message = document.getElementById('message').value;
        if(message!= ""){
            socket.emit('message', {
                appid : config.appid,
                userid:config.userid,
                type:"message" ,
                session:config.sessionid,
                orgi:config.orgi,
                message : message
            });
        }
    }else if(service_end == true){
        alert("坐席已断开和您的对话");
    }
    editor.html('');
}
function output(message , clazz) {
    if(clazz == "message connect-message"){
        var messages = document.getElementsByClassName("connect-message") ;
        for(inx =0 ; inx < messages.length ; ){
            document.getElementById('above').removeChild(messages[inx]) ;
            inx++ ;
        }
    }
    var element = ("<div class='clearfix "+clazz+"'>" +" " + message + "</div>");
    document.getElementById('above').innerHTML= (document.getElementById('above').innerHTML + element);
    document.getElementById('above').scrollTop = document.getElementById('above').scrollHeight  ;
}
function update(id , message) {
    document.getElementById(id).innerHTML= message;
}

var message={
    // text:data.message,
    // picture:function(){

    // }
    // file:function(){

    // }
    // lang:function(){

    // }
    // goods:function(){

    // }
    // POI:function(){

    // }

}



// 回车事件
// document.onkeyup=function(e){
//     if(!e) e=window.event;
//     if((e.keyCode||e.which)==13){
//         document.getElementById('sent').click();
//     }
// }
window.onresize = function(){
    R3Helper.resize();
};