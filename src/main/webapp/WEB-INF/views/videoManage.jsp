<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台管理</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/templatemo-style.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <%--swal弹框--%>
    <script src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css">

</head>
<body>
<!-- Left column -->
<div class="templatemo-flex-row">
    <%--侧边导航栏--%>
    <jsp:include page="sidebar.jsp"></jsp:include>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <%--添加用户页面列表上面的页签--%>
        <jsp:include page="userNav.jsp"/>
        <div class="templatemo-content-container">
            <div class="templatemo-content-widget no-padding">
                <div class="panel panel-default table-responsive">
                    <table id="goodsinfo" class="table table-striped table-bordered templatemo-user-table">
                        <thead>
                        <tr>
                            <td><a href="" class="white-text templatemo-sort-by">视频编号<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">视频名称<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">视频地址<span class="caret"></span></a></td>
                            <td><a href="" class="white-text templatemo-sort-by">视频内容<span class="caret"></span></a></td>
                            <td>操作</td>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>

            <div class="pagination-wrap" id="page-div-nav">
                <div class="page-info" id="page-info-area">
                </div>
            </div>
        </div>
    </div>
</div>

<%--修改用户信息模态框--%>
<!-- Modal -->
<div class="modal fade" id="update-user" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="update-form" name="update-form" method="post">
<%--                    仅仅是在传递参数，临时传递一下，不做展示--%>
                    <input type="hidden" class="form-control" name="userid" id="userid">

                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="username" id="username">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-9">
                            <input type="email" class="form-control" name="email" id="email">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="phone" class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-9">
                            <input type="number" class="form-control" name="phone" id="phone">
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveUpdate">保存</button>
            </div>
        </div>
    </div>
</div>

<%--在webapp下面的js里面有userManager.js文件，看看这个！--%>
<div id="path" style="display: none;">${pageContext.request.contextPath}</div>
<!-- JS -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
<script src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
<script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
<script>

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/templatemo-script.js"></script>      <!-- Templatemo Script -->
<script src="${pageContext.request.contextPath}/js/videoManage.js"></script>
</body>
</html>
