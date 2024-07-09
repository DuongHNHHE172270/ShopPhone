<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">


        <title>bs4 edit profile page - Bootdey.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            body{
                margin-top:20px;
                background:#f8f8f8
            }
            .img_ava {
                width: 140px;
                /* height: 105px; */
            }
        </style>
    </head>
    <body>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <div class="container">
            <div class="row flex-lg-nowrap">
                <div class="col-12 col-lg-auto mb-3" style="width: 200px;">
                    <div class="card p-3">
                        <div class="e-navlist e-navlist--active-bg">
                            <ul class="nav">
                                <li class="nav-item"><a class="nav-link px-2 active" href="home"><i class="fa fa-fw fa-bar-chart mr-1"></i><span>Back</span></a></li>                                
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="row">
                        <div class="col mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="e-profile">
                                        <div class="row">
                                            <div class="col-12 col-sm-auto mb-3">
                                                <div class="mx-auto" style="width: 140px;">
                                                    <div class="d-flex justify-content-center align-items-center rounded" style="height: 140px; background-color: rgb(233, 236, 239);">
                                                        <span style="color: rgb(166, 168, 170); font: bold 8pt Arial;"><img class="img_ava" src="${requestScope.u.avatar}"/></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col d-flex flex-column flex-sm-row justify-content-between mb-3">
                                                <div class="text-center text-sm-left mb-2 mb-sm-0">
                                                    <h4 class="pt-sm-2 pb-1 mb-0 text-nowrap">${requestScope.u.userName}</h4>
                                                    <p class="mb-0">@${requestScope.u.userName}</p>
                                                    <div class="text-muted"><small></small></div>
                                                    <div class="mt-2">

                                                    </div>
                                                </div>
                                                <div class="text-center text-sm-right">

                                                </div>
                                            </div>
                                        </div>
                                        <ul class="nav nav-tabs">
                                            <li class="nav-item"><a href class="active nav-link">Settings</a></li>
                                        </ul>
                                        <div class="tab-content pt-3">
                                            <div class="tab-pane active">
                                                <form action="user_profile" method="post" onsubmit="return comfirmSubmit()">
                                                    <input type = "hidden" name="comfirm" value="true" />
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="row">
                                                                <div class="col">
                                                                    <div class="form-group">
                                                                        <label>UserId</label>
                                                                        <input class="form-control" type="text" name="" value="${requestScope.u.userId}" disabled>

                                                                    </div>
                                                                </div>
                                                                <div class="col">
                                                                    <div class="form-group">
                                                                        <label>Full name</label>
                                                                        <input class="form-control" type="text" name="fName" value="${requestScope.u.fullName}">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col">
                                                                    <div class="form-group">                                                                                                                 
                                                                        <label>Phone</label>
                                                                        <input class="form-control" type="text" name="phone" value="${requestScope.u.phone}">
                                                                        <label>Address</label>
                                                                        <input class="form-control" type="text" name="address" value="${requestScope.u.address}">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">

                                                            </div>
                                                        </div>
                                                    </div>                              
                                                    <input class="form-control" type="hidden" name="uId" value="${requestScope.u.userId}">
                                                    <button class="btn btn-primary" type="submit" name="action" value="update">Save Changes</button>

                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">
                                                    function comfirmSubmit() {
                                                        return confirm("Are you sure you want to update?");
                                                    }
                                                    // Kiểm tra nếu có thông báo lỗi được gửi từ servlet
            <c:if test="${not empty error}">
             alert("${error}");
            </c:if>

                                                    // Kiểm tra nếu có thông báo thành công được gửi từ servlet
            <c:if test="${not empty success}">
              alert("${success}");
            </c:if>

        </script>
    </body>
</html>
