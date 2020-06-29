var runningDay = new Date();
var todayStr = runningDay.getFullYear().toString()+ ((runningDay.getMonth()+1)>9 ? (runningDay.getMonth()+1).toString() : ('0' + (runningDay.getMonth()+1).toString())) + ((runningDay.getDate()+1)>9 ? (runningDay.getDate()+1).toString() : ('0' + (runningDay.getDate()+1).toString()));
var ignore_key_elms = ["#header, #left-panel, #main, div.page-footer"]; //, /* #right-panel, #shortcut, #divSmallBoxes, #divMiniIcons, #divbigBoxes, #voiceModal, script, .ui-chatbox
var bread_crumb = $('#ribbon ol.breadcrumb');

//Html编码获取Html转义实体
function htmlEncode(value){
    return $('<div/>').text(value).html();
}
//Html解码获取Html实体
function htmlDecode(value){
    return $('<div/>').html(value).text();
}

function loadScript(scriptNameVar) {
    var scriptName = scriptNameVar;
    if(scriptName && scriptName.indexOf('?') == -1){
        scriptName = scriptName + "?t=" + todayStr;
    }else{
        scriptName = scriptName + "&t=" + todayStr;
    }
    if ( !jsArray[scriptName]  ) {
        var promise = jQuery.Deferred();

        // adding the script tag to the head as suggested before
        var body = document.getElementsByTagName('body')[0],
            script = document.createElement('script');
        script.type = 'text/javascript';
        script.src = scriptName;

        // then bind the event to the callback function
        // there are several events for cross browser compatibility
        script.onload = function () {
            promise.resolve();
            if(typeof pagefunction === 'function'){
                pageFunctionArray[scriptName] = pagefunction;
            }
        };

        // fire the loading
        body.appendChild(script);

        // clear DOM reference
        //body = null;
        //script = null;
        jsArray[scriptName] = promise.promise();

        /*} else if (debugState)
         root.root.console.log("This script was already loaded %c: " + scriptName, debugStyle_warning);

         jsArray[scriptName].then(function () {
         if(typeof callback === 'function')
         callback();
         });*/
    }else{
        jsArray[scriptName].then(function () {
            var pagefunction = pageFunctionArray[scriptName];
            if(typeof pagefunction === 'function')
                pagefunction();
        });
    }
}

/* ~ END: LOAD SCRIPTS */


// $( document ).ready(function() {
function initAjaxLoadPage(){
    // fire this on page load if nav exists
    if ($('.layui-layout-content .kty-nav-child a').length) {
        checkKtyURL();
    }

    $(document).on('click', '.layui-layout-content .kty-nav-child a[href!="#"]', function(e) {
        e.preventDefault();
        var $this = $(e.currentTarget);

        // if parent is not active then get hash, or else page is assumed to be loaded
        if (!$this.parent().hasClass("active") && !$this.attr('target')) {

            // update window with hash
            // you could also do here:  thisDevice === "mobile" - and save a little more memory

            if (window.location.search) {
                window.location.href =
                    window.location.href.replace(window.location.search, '')
                        .replace(window.location.hash, '') + '#' + $this.attr('href');
            } else {
                window.location.hash = $this.attr('href');
            }

            // clear DOM reference
            // $this = null;
        }

    });

    // fire links with targets on different window
    $(document).on('click', '.layui-layout-content .kty-nav-child a[target="_blank"]', function(e) {
        e.preventDefault();
        var $this = $(e.currentTarget);

        window.open($this.attr('href'));
    });

    // fire links with targets on same window
    $(document).on('click', '.layui-layout-content .kty-nav-child a[target="_top"]', function(e) {
        e.preventDefault();
        var $this = $(e.currentTarget);

        window.location = ($this.attr('href'));
    });

    // all links with hash tags are ignored
    $(document).on('click', '.layui-layout-content .kty-nav-child a[href="#"]', function(e) {
        e.preventDefault();
    });

    // DO on hash change
    $(window).on('hashchange', function() {
        checkKtyURL();
    });
};

/*
 * CHECK TO SEE IF URL EXISTS
 */
function checkKtyURL() {

    //get the url by removing the hash
    //var url = location.hash.replace(/^#/, '');
    var url = location.href.split('#').splice(1).join('#');
    //BEGIN: IE11 Work Around
    console.log("check kty url:", url);
    if (!url) {

        try {
            var documentUrl = window.document.URL;
            if (documentUrl) {
                if (documentUrl.indexOf('#', 0) > 0 && documentUrl.indexOf('#', 0) < (documentUrl.length + 1)) {
                    url = documentUrl.substring(documentUrl.indexOf('#', 0) + 1);

                }

            }

        } catch (err) {
        }
    }

    //END: IE11 Work Around

    container = $('#main-kf-active-content');
    // Do this if url exists (for page refresh, etc...)
    if (url) {

        // remove all active class
        /* $('nav li.active').removeClass("active"); */
        // match the url and add the active class
        /* $('nav li:has(a[href="' + url + '"])').addClass("active"); */
        var title = ($('.layui-layout-content .kty-nav-child a[href="' + url + '"]').attr('title'));

        // change page title from global var
        document.title = (title || document.title);

        // parse url to jquery
        loadKtyURL(url + location.search, container);

    } else {
//            if(true){
//                window.location.hash = "home.html";
//                //clear dom reference
//
//                $this = null;
//
//                return;	// fix the undefine # in url
//            }
        // grab the first URL from nav
        var $this = $($('.layui-layout-content .kty-nav-child a[href!="#"]')[0]);

        //update hash
        window.location.hash = $this.attr('href');
        //clear dom reference
        $this = null;

    }

}

/*
 * LOAD AJAX PAGES
 */
function loadKtyURL(urlVar, container) {
    if(!urlVar){
        return;
    }
    var url = urlVar;
    if(url && url.indexOf('?') == -1){
        url = url + "?t=" + todayStr;
    }else {
        url = url + "&t=" + todayStr;
    }
    $.ajax({
        type : "GET",
        url : url,
        dataType : 'html',
        cache : true, // (warning: setting it to false will cause a timestamp and will call the request twice)
        beforeSend : function() {

            //IE11 bug fix for googlemaps (delete all google map instances)
            //check if the page is ajax = true, has google map class and the container is #content
            if ($(".google_maps")[0] && (container[0] == $("#content")[0]) ) {

                // target gmaps if any on page
                var collection = $(".google_maps"),
                    i = 0;
                // run for each	map
                collection.each(function() {
                    i ++;
                    // get map id from class elements
                    var divDealerMap = document.getElementById(this.id);

                    if(i == collection.length + 1) {
                        // "callback"
                    } else {
                        // destroy every map found
                        if (divDealerMap) divDealerMap.parentNode.removeChild(divDealerMap);

                        // debugState
                        if (debugState){
                            root.Console.log("Destroying maps.........%c" + this.id, debugStyle_warning);
                        }
                    }
                });

                // debugState
                if (debugState){
                    root.Console.log("✔ Google map instances nuked!!!");
                }

            } //end fix

            // destroy all datatable instances
            if ($('.dataTables_wrapper')[0] && (container[0] == $("#content")[0]) ) {

                var tables = $.fn.dataTable.fnTables(true);
                $(tables).each(function () {

                    if($(this).find('.details-control').length != 0) {
                        $(this).find('*').addBack().off().remove();
                        $(this).dataTable().fnDestroy();
                    } else {
                        $(this).dataTable().fnDestroy();
                    }

                });
            }
            // end destroy

            // cluster destroy: destroy other instances that could be on the page
            // this runs a script in the current loaded page before fetching the new page
            if ( (container[0] == $("#content")[0]) ) {

                /*
                 * The following elements should be removed, if they have been created:
                 *
                 *	colorList
                 *	icon
                 *	picker
                 *	inline
                 *	And unbind events from elements:
                 *
                 *	icon
                 *	picker
                 *	inline
                 *	especially $(document).on('mousedown')
                 *	It will be much easier to add namespace to plugin events and then unbind using selected namespace.
                 *
                 *	See also:
                 *
                 *	http://f6design.com/journal/2012/05/06/a-jquery-plugin-boilerplate/
                 *	http://keith-wood.name/pluginFramework.html
                 */

                // this function is below the pagefunction for all pages that has instances

                if (typeof pagedestroy == 'function') {

                    try {
                        pagedestroy();

                        if (debugState){
                            root.Console.log("✔ Pagedestroy()");
                        }
                    }
                    catch(err) {
                        pagedestroy = undefined;

                        if (debugState){
                            root.Console.log("! Pagedestroy() Catch Error");
                        }
                    }

                }

                // destroy all inline charts

                if ( $.fn.sparkline && $("#content .sparkline")[0] ) {
                    $("#content .sparkline").sparkline( 'destroy' );
                }

                if ( $.fn.easyPieChart && $("#content .easy-pie-chart")[0] ) {
                    $("#content .easy-pie-chart").easyPieChart( 'destroy' );
                }



                // end destory all inline charts

                // destroy form controls: Datepicker, select2, autocomplete, mask, bootstrap slider

                if ( $.fn.select2 && $("#content select.select2")[0] ) {
                    $("#content select.select2").select2('destroy');
                }

                if ( $.fn.mask && $('#content [data-mask]')[0] ) {
                    $('#content [data-mask]').unmask();
                }

                if ( $.fn.datepicker && $('#content .datepicker')[0] ) {
                    $('#content .datepicker').off();
                    $('#content .datepicker').remove();
                }

                if ( $.fn.slider && $('#content .slider')[0] ) {
                    $('#content .slider').off();
                    $('#content .slider').remove();
                }

                // end destroy form controls


            }
            // end cluster destroy

            // empty container and var to start garbage collection (frees memory)
            pagefunction = null;
            container.removeData().html("");

            // place cog
            container.html('<h1 class="ajax-loading-animation"><i class="fa fa-cog fa-spin"></i> 正在载入...</h1>');

            // Only draw breadcrumb if it is main content material
            if (container[0] == $("#content")[0]) {

                // clear everything else except these key DOM elements
                // we do this because sometime plugins will leave dynamic elements behind
                $('body').find('> *').filter(':not(' + ignore_key_elms + ')').empty().remove();

                // draw breadcrumb
                drawBreadCrumb();

                // scroll up
                $("html").animate({
                    scrollTop : 0
                }, "fast");
            }
            // end if
        },
        success : function(data) {
            // dump data to container
            container.css({
                opacity : '0.0'
            }).html(data).delay(50).animate({
                opacity : '1.0'
            }, 300);

            // clear data var
            data = null;
            container = null;
        },
        error : function(xhr, status, thrownError, error) {
            container.html('<h4 class="ajax-loading-error"><i class="fa fa-warning txt-color-orangeDark"></i> Error requesting <span class="txt-color-red">' + url + '</span>: ' + xhr.status + ' <span style="text-transform: capitalize;">'  + thrownError + '</span></h4>');
        },
        async : true
    });

}

/*
 * UPDATE BREADCRUMB
 */
function drawBreadCrumb(opt_breadCrumbs) {
    var a = $("nav li.active > a"),
        b = a.length;

    bread_crumb.empty(),
        bread_crumb.append($("<li>首页</li>")), a.each(function() {
        bread_crumb.append($("<li></li>").html($.trim($(this).clone().children(".badge").remove().end().text()))), --b || (document.title = bread_crumb.find("li:last-child").text())
    });

    // Push breadcrumb manually -> drawBreadCrumb(["Users", "John Doe"]);
    // Credits: Philip Whitt | philip.whitt@sbcglobal.net
    if (opt_breadCrumbs != undefined) {
        $.each(opt_breadCrumbs, function(index, value) {
            bread_crumb.append($("<li></li>").html(value));
            document.title = bread_crumb.find("li:last-child").text();
        });
    }
}
/* ~ END: APP AJAX REQUEST SETUP */

var datatableLanguage = {
    lengthMenu: "每页显示 _MENU_ 条记录",
    zeroRecords: "没有检索到数据",
    emptyTable: "没有数据",
    info: "共有 _TOTAL_ 条记录",
    processing: "<div class=\"icon\"><i class=\"kfont\">&#xe63d;</i></div>",
    loadingRecords: "<div class=\"icon\"><i class=\"kfont\">&#xe63d;</i>正在载入。。。</div>",
    //search: '<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>',
    search: '<span class="input-group-addon"><i class="layui-icon" onclick="" style="position: absolute;cursor: pointer;right: 3px;top: 4px;font-size: 15px;"></i></span>',
    infoEmpty: "共 0 条记录",
    infoFiltered:"(从 _MAX_ 条记录查找到)",
    stateSave: false,
    paginate: {
    first: "首页",
        previous: "前页",
        next: "后页",
        last: "尾页"
},
};

var breakpointDefinition = {
    tablet: 1024,
    phone: 480
};

function commonDataTable(tableSetting) {
    var sortIndex = -1;
    var orderby = tableSetting.orderby;

    $.each(tableSetting.columns, function (i, item) {
        if (orderby) {
            if (item.data && item.data == orderby) {
                sortIndex = i;
            }
        } else {
            if (item.data && item.data === 'createtime') {
                sortIndex = i;
            }
        }

        if (!item.className) {
            item.className = "center";
        }
        item["orderSequence"] = ["desc", "asc"];
        if (typeof item.render !== 'function') {
            item.render = function (data, type, full) {
                return (data || data === 0 ) ? data : "-";
            }
        } else {
            var tmpFun = item.render;
            item.render = function (data, type, full) {
                var tmpText = tmpFun(data, type, full);

                if (typeof tmpText === 'string') {
                    if (tmpText.indexOf('<') != -1) {
                        return tmpText;
                    } else {
                        return htmlEncode(tmpText);
                    }
                } else {
                    return tmpText;
                }
            }

        }
    });

    var columnLength = tableSetting.columns.length;
    var columnWith = 100 / columnLength;
    tableSetting.columns.forEach(function (value, index, array1) {
        value.defaultContent = "";
//            if (!value.width) {
//                value.width = columnWith + "%";
//            }
        if (!value.className) {
            value.className = "center";
        }
    });

    if (sortIndex >= 0) {

        if (tableSetting.direction) {
            tableSetting.order = [[sortIndex, tableSetting.direction]];
        } else {
            tableSetting.order = [[sortIndex, "desc"]];
        }
    }
    tableSetting.destroy = true;
    tableSetting.language = datatableLanguage;

    //tableSetting.dom ="<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-sm-6 col-xs-12 hidden-xs'l>r>t<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-xs-12 col-sm-6'p>>",
    tableSetting.autoWidth = true;
    tableSetting.filter = false;
    tableSetting.serverSide = true;
    tableSetting.sAjaxDataProp = "datas";

    if(!tableSetting.preDrawCallback) {
        tableSetting.preDrawCallback = function () {
            // Initialize the responsive datatables helper once.
            if (!tableSetting.responsiveHelper_dt_basic) {
                tableSetting.responsiveHelper_dt_basic = new ResponsiveDatatablesHelper(tableSetting.table, breakpointDefinition);
            }
        };
    }
    if(!tableSetting.rowCallback) {
        tableSetting.rowCallback = function (nRow) {
            if (tableSetting.responsiveHelper_dt_basic) {
                tableSetting.responsiveHelper_dt_basic.createExpandIcon(nRow);
            }
        };
    }
    if(!tableSetting.drawCallback) {
        tableSetting.drawCallback = function (oSettings) {
            if (tableSetting.responsiveHelper_dt_basic) {
                tableSetting.responsiveHelper_dt_basic.respond();
                root.Console.log("Completed draw table!");
            }
        };
    }

    return tableSetting.table.dataTable(tableSetting);
}

$(function(){
    ajaxSetup();

});

$('body').delegate('.close-layerwin-window', 'click', function () {
    top.layer.close(top.layerwin);
});

function openPhonePanel(phoneNumber){
    if(phoneNumber && phoneNumber.length == 11 && !isNaN(phoneNumber)){
        top.openPanelMakeCall(phoneNumber,false);
    }
    return false;
}

var feedbackStatus = {draft:0, submit:1,end:2};