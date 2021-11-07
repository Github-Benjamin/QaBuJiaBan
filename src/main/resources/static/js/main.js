/**
 * Created by Anonymous on 2017/9/26.
 */

// ifame框架打开页面
var openpage = function (href) {
    $(".addpage").empty();
    var html = '<iframe id="iframe-page-content" src="'+href+'" width="100%"  frameborder="no" border="0" marginwidth="0" marginheight=" 0" scrolling="no" allowtransparency="yes"></iframe>'
    $(".addpage").append(html);
    var ifm= document.getElementById("iframe-page-content");
    ifm.height=document.documentElement.clientHeight+220;
}

//加载ifame框架
$(".addmeu").click(function(){
    var href= $(this).attr("data-href");
    openpage(href);
});

// 图片预览,鼠标移上时触发弹出提示框，开启html 为true的话，data-content里就能放html代码了
$("[data-toggle='popover']").popover({
    trigger : 'hover',
    html:true,
});



// 删除Banner、电影操作
$(".delid").click(function () {
    $("#delcfmModel").modal();
    var delid= $(this).attr("id");
    $("#delid").val(delid);
});


// 修改新闻操作
$(".upnews").click(function () {
    var upid= $(this).attr("id");
    var uptitle= $(this).attr("data-title");
    var upauthor= $(this).attr("data-author");
    var uptime= $(this).attr("data-uptime");

    $.ajax({
            type: "GET",
            url: "admins/news",
            dataType:'json',
            data:{"queryid":upid},
            success: function(data){
                    if (data["success"]) {
                        callbackeditor.html(data["success"]);
                    }
            },
            error: function (data) {
                $(".alert-warning").remove();
                $(".error").append('<div class="alert alert-warning" id="error" style="display: block;width: 280px"> <a href="#" class="close" data-dismiss="alert">&times;</a> <strong>警告！</strong>您的网络连接有问题。 </div>');
            }
        });

    $("#upid").val(upid);
    $("#uptitle").val(uptitle);
    $("#upauthor").val(upauthor);
    $("#upselecttime").val(uptime);
    $("#UPmyModal").modal();

});



