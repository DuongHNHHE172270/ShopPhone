
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Model.OrderDetail" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">


        <title>bs4 crud users - Bootdey.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            body{
                margin-top:20px;
                background:#f8f8f8
            }
            img.img_ava {
                width: 40px;
            }
            button.btn.btn-sm.btn-outline-secondary.badge {
                border-radius: 30%;
            }
            button.btn.btn-sm.btn-outline-secondary.badge {
                width: 30px;
                height: 26px;
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
                                 <li class="nav-item"><a class="nav-link px-2" href="home"><i class="fa fa-fw fa-bar-chart mr-1"></i><span>Home</span></a></li>
                                <li class="nav-item"><a class="nav-link px-2 " href="manager"><i class="fa fa-fw fa-bar-chart mr-1"></i><span>User</span></a></li>
                                <li class="nav-item"><a class="nav-link px-2" href="category"><i class="fa fa-fw fa-bar-chart mr-1"></i><span>Category</span></a></li>
                                <li class="nav-item"><a class="nav-link px-2" href="manager_product"><i class="fa fa-fw fa-bar-chart mr-1"></i><span>Product</span></a></li>
                                <li class="nav-item"><a class="nav-link px-2" href="orders"><i class="fa fa-fw fa-bar-chart mr-1"></i><span>Order</span></a></li>
                                
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="e-tabs mb-3 px-3">
                        <ul class="nav nav-tabs">
                            <li class="nav-item"><a class="nav-link ${requestScope.nameA == products ? "active" : ""}" href="">Products</a></li>

                        </ul>
                    </div>
                    <div class="row flex-lg-nowrap">
                        <div class="col mb-3">
                            <div class="e-panel card">
                                <div class="card-body">
                                    <div class="card-title">
                                        <h6 class="mr-2"><span>Product</span></h6>
                                    </div>
                                    <div class="e-table">
                                        <div class="table-responsive table-lg mt-3">
                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th class="align-top">
                                                            Oid
                                                        </th>
                                                        
                                                        <th class="max-width">User name</th>
                                                        <th class="sortable">Product name</th>
                                                        <th>Price</th>
                                                        <th>Booking Date</th>
                                                        
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                 ArrayList<OrderDetail> orderDetails = (ArrayList<OrderDetail>) request.getAttribute("orderDetails");
                                 if(orderDetails != null && !orderDetails.isEmpty()){
                                 for(OrderDetail o : orderDetails) {
                                                    %>
                                                    <tr>
                                                        <td class="align-middle">
                                                            <div class="custom-control custom-control-inline custom-checkbox custom-control-nameless m-0 align-top">
                                                                <%= o.getOrderDetailId()%>
                                                            </div>
                                                        </td>
                                                        
                                                        <td class="text-nowrap align-middle"><%=o.getOrderId().getUserId().getUserName()%></td>
                                                        <td class="text-nowrap align-middle"><span><%= o.getProductId().getProductName()%></span></td>
                                                        <td class="text-center align-middle">
                                                            <%= o.getPrice()%>
                                                        </td>
                                                        <td class="text-center align-middle">
                                                            <%=o.getOrderId().getBookingDate()%>
                                                        </td>
                                                        
                                                    </tr>
                                                    <%
                                                                                   }
}
                                                    %>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="d-flex justify-content-center">
                                            <ul class="pagination mt-3 mb-0">
                                                <c:if test="${requestScope.indexPage > 1}">
                                                    <li class="page-item"><a href="manager_product?index=${requestScope.indexPage - 1}&search=${requestScope.search}" class="page-link">‹</a></li>
                                                    </c:if>

                                                <c:forEach begin="1" end="${requestScope.numberPage}" var="i">
                                                    <li class="page-item ${requestScope.indexPage == i ? 'active' : ''}"><a href="manager_product?index=${i}&search=${requestScope.search}" class="page-link">${i}</a></li>
                                                    </c:forEach>
                                                    <c:if test="${requestScope.indexPage < requestScope.numberPage}">
                                                    <li class="page-item"><a href="manager_product?index=${requestScope.indexPage + 1}&search=${requestScope.search}" class="page-link">›</a></li>                 
                                                    </c:if>

                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-lg-3 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="text-center px-xl-3">

                                        <button onclick="location.href='logout'" class="btn btn-block btn-secondary">
                                            <i class="fa fa-sign-out"></i>
                                            <span>Logout</span>
                                        </button>

                                        
                                    </div>
                                    <hr class="my-3">
                                    <div class="e-navlist e-navlist--active-bold">
                                        <ul class="nav">
                                            <li class="nav-item active"><a href class="nav-link"><span>Total Order</span>&nbsp;<small>/&nbsp;${requestScope.totalOrder}</small></a></li>
                                            <li class="nav-item active"><a href class="nav-link"><span>Total Money</span>&nbsp;<small>/&nbsp;${requestScope.totalOrderMoney}</small></a></li>
                                        </ul>
                                    </div>
                                    <hr class="my-3">
                                    <div>
                                        <div class="form-group">

                                        </div>
                                        <div class="form-group">
                                            <form action="orders" method="post">
                                                <label>Search by Name:</label>
                                                <div><input name="oName" class="form-control w-100" type="text" placeholder="Name"></div>
                                                <input name="indexPage" type="hidden" value="${requestScope.indexPage}"/>
                                                <button type="submit" style="margin-top: 8px" class="btn btn-block btn-secondary">
                                                    <span>Search</span>
                                                </button>
                                            </form>

                                        </div>
                                    </div>
                                    <hr class="my-3">
<p style="text-align: center;
                                           color: #c45050" class="p_wel">Welcome ${sessionScope.account.getUserName()}</p>
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
                                            
        </script>
    </body>
</html>
