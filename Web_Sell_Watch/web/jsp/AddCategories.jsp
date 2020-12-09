<%-- 
    Document   : NewProduct
    Created on : Aug 23, 2020, 4:26:24 PM
    Author     : ThinkPad T440s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Store Watch</title>
        <meta name="description" content="Store Watch">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
        <link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <link rel="stylesheet" href="../jsp/admin/Content/css/style.css">
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
        <title>New Categories</title>
        <style >
            #table {

                background-color: white;

                padding: 30px;
                border-radius: 5px;
                margin: 0 auto;
            }
            body {
                background-color: #343a40;
            }
            input{
                margin-top: 10px;
                margin-bottom: 5px;
                margin-left: 30px;
            }

            select {
                margin-top: 10px;
                margin-bottom: 5px;
                margin-left: 30px;
            }
            #sub {
                margin-left: 250px;
                margin-top: 10px;
            }
            #table th {
                padding-bottom: 20px;
            }
            .e {
                color: red;
                margin-left: 30px;
            }
            .t{
                margin-top: 10px;
            }
        </style>

    </head>

    <body>
        <script type="text/javascript">
            $(document).ready(function () {
                $('input[type="submit"]').click(function (e) {
                    if ($('#catName').val() == "" || $('#catId').val() == "") {
                        e.preventDefault();
                        $('#errocatId').text("");
                        $('#errocatName').tedxt("");
                        if ($('#catId').val() == "") {
                            $('#errocatId').text("Please enter CatId");
                        }
                        if ($('#catName').val() == "") {
                            $('#errocatName').text("Please enter CatName");
                        }
                    } else {
                        return true;
                    }
                })
            })
        </script>
        <!-- Left Panel -->

        <aside id="left-panel" class="left-panel">
            <nav class="navbar navbar-expand-sm navbar-default">
                <div id="main-menu" class="main-menu collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="${contextPath}/Web_Sell_Watch/CatController/getAll.htm"><i class="fa fa-laptop"></i>Dashboard </a>
                        </li>
                        <li class="menu-title">Manage</li><!-- /.menu-title -->
                        <li class="menu-item-has-children ">
                            <a href="${contextPath}/Web_Sell_Watch/CatController/getAll.htm"> <i class="ti-menu-alt"></i> Manage Categorys</a>
                        </li>
                        <li class="menu-item-has-children ">
                            <a href="${contextPath}/Web_Sell_Watch/ProdcController/getAll.htm"> <i class="ti-menu-alt"></i> Manage Producers</a>
                        </li>
                        <li class="menu-item-has-children ">
                            <a href="${contextPath}/Web_Sell_Watch/ProController/getAll.htm"> <i class="ti-menu-alt"></i>Manage Product</a>
                        </li>
                        
                        <li class="menu-item-has-children ">
                            <a href="${contextPath}/Web_Sell_Watch/OrderController/getAll.htm"><i class="fa fa-shopping-cart"></i> Manage Order</a>
                        </li>

                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>
        </aside><!-- /#left-panel -->
        <!-- Left Panel -->
        <div id="right-panel" class="right-panel">
            <f:form action="insert.htm" method="POST" commandName="catNew">
                <table id="table">
                    <tr>
                        <th colspan="2">New Categories</th>
                    </tr>

                    <tr>
                        <td>Categories Id</td>
                        <td><f:input id="catId" path="catId"/>
                        </td>

                    </tr>
                    <tr>
                        <td></td>
                        <td><samp class="e" id="errocatId"></samp> </td>
                    </tr>
                    <tr>
                        <td>Categories Name</td>
                        <td><f:input id="catName" path="catName"/>
                        </td>

                    </tr>
                    <tr>
                        <td></td>
                        <td><samp class="e" id="errocatName"></samp> </td>
                    </tr>

                    <tr class="t">
                        <td>Descriptons </td>
                        <td><f:input id="descriptons" path="descriptons"/>
                        </td>

                    </tr>
                    <tr>
                        <td></td>
                        <td><samp class="e" id="errocatdescriptons"></samp> </td>
                    </tr>
                    <tr>
                        <td>Categories Status</td>
                        <td>
                            <f:select path="catStatus">
                                <f:option value="true">Active</f:option>
                                <f:option value="false">InActive</f:option>
                            </f:select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" ><input type="submit" value="Create" id="sub"/></td>
                    </tr>
                </table>
            </f:form>
        </div>
    </body>
</html>
