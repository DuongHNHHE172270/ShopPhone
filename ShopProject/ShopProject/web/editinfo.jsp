<%-- 
    Document   : editinfo
    Created on : Mar 2, 2024, 1:36:20 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                <li class="nav-item"><a class="nav-link px-2 active" href="manager"><i class="fa fa-fw fa-bar-chart mr-1"></i><span>Back</span></a></li>                                
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
                                                    <span class="badge badge-secondary">${requestScope.u.role == 0 ? "administrator" : "User"}</span>
                                                    <div class="text-muted"><small></small></div>
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="nav nav-tabs">
                                            <li class="nav-item"><a href class="active nav-link">Settings</a></li>
                                        </ul>
                                        <div class="tab-content pt-3">
                                            <div class="tab-pane active">
                                                <form action="editinfo" method="post" onsubmit="return comfirmSubmit()">
                                                    <input type = "hidden" name="comfirm" value="true" />
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="row">
                                                                <div class="col">
                                                                    <div class="form-group">
                                                                        <label>Full Name</label>
                                                                        <input class="form-control" type="text" name="name" placeholder="${requestScope.u.userName}" value="${requestScope.u.userName}" disabled>
                                                                    </div>
                                                                </div>
                                                                <div class="col">
                                                                    <div class="form-group">
                                                                        <label>Username</label>
                                                                        <input class="form-control" type="text" name="username" placeholder="${requestScope.u.fullName}" value="${requestScope.u.fullName}" disabled>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col">
                                                                    <div class="form-group">
                                                                        <input class="form-control" type="text" name="phone" placeholder="${requestScope.u.phone}" value="${requestScope.u.phone}" disabled>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col mb-3">
                                                                    <div class="form-group">

                                                                        <input class="form-control" type="text" name="address" placeholder="${requestScope.u.address}" value="${requestScope.u.address}" disabled>
                                                                        <input style="margin-top: 18px " class="form-control" type="text" name="role" value="${requestScope.u.role}">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>                              
                                                    <input class="form-control" type="hidden" name="userId" value="${requestScope.uid}">
                                                 
                                                    <button class="btn btn-primary" type="Sumit" name="action" value="update">Save Changes<button/>

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
                                                        return confirm("Are you sure you want to update this human?");
                                                    }
                                                    
        </script>
    </body>
</html>
