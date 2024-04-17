
$(document).ready(function () {

    var path = $("#path").text();

    var currentPage = 1;

    to_page(path, 1);


});

// 点击编辑后出现模态框
$(document).on("click",".templatemo-edit-btn",function () {
    $("#update-user").modal({
        backdrop:'static'
    });
    var userId = $(this).parents("tr").find("td:eq(0)").text();
    var username = $(this).parents("tr").find("td:eq(1)").text();
    var email = $(this).parents("tr").find("td:eq(2)").text();
    var phoneNumber = $(this).parents("tr").find("td:eq(3)").text();


    $("#userid").val(userId);
    $("#username").val(username);
    $("#email").val(email);
    $("#phone").val(phoneNumber);

});

//执行保存操作，点击模态框的保存后执行这个方法
$(document).on("click","#saveUpdate",function () {
    var userId = $("#userid").val();
    var username = $("#username").val();
    var email = $("#email").val();
    var phone = $("#phone").val();

    $.ajax({
        url:"/shop/admin/user/update/",
        type:"POST",
        data:{
            userid:userId,
            username:username,
            email:email,
            telephone:phone
        },
        success:function(result){
            // 隐藏这个模态框
            $("#update-user").modal('hide');
            swal(result.msg,'','success');
            to_page('/shop',currentPage);
        },
        error:function(){
            alert("错误！！");
        }
    });
});

function to_page(path, page) {
    $.ajax({
        url: path + "/admin/user/showjson",
        data: "page=" + page,
        type: "get",
        success: function (result) {

            //解析显示
            build_user_table(path, result);

            //页面信息
            build_page_info(path, result);

            //分页
            build_page_nav(path, result);

            currentPage = page;
        }
    });
}

function build_user_table(path,result) {
    $("#goodsinfo tbody").empty();
    var goods = result.info.pageInfo.list;
    $.each(goods, function (index,item) {
        var userid = $("<td></td>").append(item.userid);
        var username = $("<td></td>").append(item.username);
        var editBtn = $("<button></button>").addClass("templatemo-edit-btn").append("修改密码");
        var operateTd = $("<td></td>").append(editBtn)
        $("<tr></tr>").append(userid)
            .append(username)
            .append(operateTd)
            .appendTo("#goodsinfo tbody");
    })
}

function build_page_info(path,result) {
    $("#page-info-area").empty();
    $("#page-info-area").append("当前第"+ result.info.pageInfo.pageNum +"页，总共"+ result.info.pageInfo.pages +"页，总共"+ result.info.pageInfo.total +"记录")
}

function build_page_nav(path,result) {
    $("#page-div-nav ul").empty();
    var pageUl = $("<ul></ul>").addClass("pagination")

    var firstPage = $("<li></li>").append($("<a aria-label=\"Next\"></a>")
        .append($("<span aria-hidden=\"true\"></span>")
            .append("首页")));

    var prePage = $("<li></li>").append($("<a aria-label=\"Next\"></a>")
        .append($("<span aria-hidden=\"true\"><i class=\"fa fa-backward\"></i></span>")));

    if(!result.info.pageInfo.hasPreviousPage) {
        prePage.addClass("li-none");
    } else {
        prePage.click(function () {
            to_page('/shop',result.info.pageInfo.prePage);
        });
    }

    //跳转
    firstPage.click(function () {
        to_page('/shop',1);
    });

    var nextPage = $("<li></li>").append($("<a aria-label=\"Next\"></a>")
        .append($("<span aria-hidden=\"true\"><i class=\"fa fa-forward\"></i></span>")));

    var lastPage = $("<li></li>").append($("<a aria-label=\"Next\"></a>")
        .append($("<span aria-hidden=\"true\"></span>")
            .append("末页")));

    if(!result.info.pageInfo.hasNextPage) {
        nextPage.addClass("li-none");
    } else {
        nextPage.click(function () {
            to_page('/shop',result.info.pageInfo.nextPage);
        });
    }

    lastPage.click(function () {
        to_page('/shop',result.info.pageInfo.lastPage);
    });

    pageUl.append(firstPage).append(prePage);

    $.each(result.info.pageInfo.navigatepageNums,function (index,item) {
        var numLi = $("<li></li>").append($("<a></a>")
            .append($("<span aria-hidden=\"true\"></span>").append(item)));
        if(result.info.pageInfo.pageNum === item) {
            numLi.addClass("active");
        }
        numLi.click(function () {
            to_page('/shop',item);
        });
        pageUl.append(numLi);
    });

    pageUl.append(nextPage).append(lastPage).appendTo("#page-div-nav");
}