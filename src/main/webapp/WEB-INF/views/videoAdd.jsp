<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <script src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css">

</head>
<body>
<!-- Left column -->
<div class="templatemo-flex-row">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <jsp:include page="videoNav.jsp"></jsp:include>
        <div class="templatemo-content-container">
            <div class="templatemo-content-widget white-bg">
                <h2 class="margin-bottom-10">添加视频</h2>
                <form action="${pageContext.request.contextPath}/admin/video/save" class="templatemo-login-form" method="post" enctype="multipart/form-data">
                    <div class="row form-group">
                        <div class="col-lg-6 form-group">
                            <label class="control-label" for="title">
                                视频名称 <h style="font-size:12px;color: #00BCD4">(用户自定义的概括名称，没有规范)</h>
                            </label>
                            <input type="text" class="form-control" id="title" name="title">
                        </div>
                        <div class="col-lg-6 form-group">
                            <label class="control-label" for="filename">
                                文件名称 <h style="font-size:12px;color: #00BCD4">(文件完整名称，不加.mp4)</h>
                            </label>
                            <input type="text" class="form-control" id="filename" name="filename">
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-lg-12 form-group">
                            <label class="control-label" for="filepath">视频地址</label>
                            <input type="text" class="form-control" id="filepath" name="filepath">
                        </div>
                    </div>
                    <div class="form-group text-right">
                        <button type="submit" class="templatemo-blue-button">添加</button>
                        <button type="reset" class="templatemo-white-button">重置</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>        <!-- jQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-filestyle.min.js"></script>  <!-- http://markusslima.github.io/bootstrap-filestyle/ -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/templatemo-script.js"></script>        <!-- Templatemo Script -->

<%-- 根据后台传来的值来弹出成功或者失败的框框 --%>
<c:if test="${msg == '0000'}">
    <script type="text/javascript">
        $(document).ready(function () {
            swal('添加成功', '', 'success');
        });
    </script>
</c:if>
<c:if test="${msg != '0000' && msg != '' && msg != null}">
    <script type="text/javascript">
        $(document).ready(function () {
            swal('${msg}', '', 'error');
        });
    </script>
</c:if>
</body>
<script>
</script>
</html>

