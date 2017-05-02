<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%--jQueryの読み込み--%>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<%--共通cssの読み込み --%>
<!-- <link rel="stylesheet" href="./css/main.css"> -->
<%--共通jsの読み込み --%>
<%-- <script src="./js/main.js"></script> --%>
<title>決済入力画面</title>
</head>
<body>
  <div class="container">
    <%-- ヘッダー --%>
    <div class="row">
      <div class="col-xs-12 col-sm-12"">
        <jsp:include page="header.jsp" /></div>
    </div>
    <%--ヘッダー --%>

    <div class="col-xs-9" style="margin-top:50px;">
        <div class="panel panel-info">
        <table class="table ">
            <thead>
                <tr>
                    <th>お届け先の住所</th>
                    <th>お支払い方法</th>
                </tr>

            </thead>
            <tbody>
                <tr>
                    <td><s:property value="name"/></td>
                    <td>クレジットカード</td>
                </tr>
                <tr>
                    <td><s:property value="%{shippingAddress}" /></td>
                </tr>
            </tbody>
        </table>
        </div>
    </div>

    <div class="col-xs-3">
        <div class="panel panel-default">
            <div class="panel-heading" style="background:#fde8d0">
                <s:form action="SettlementAction">
                    <s:hidden name="creditNumber" value="%{creditNumber}" />
                    <s:hidden name="creditBrand" value="%{creditBrand}" />
                    <s:hidden name="securityCode" value="%{securityCode}" />
                    <s:hidden name="shippingAddress" value="%{shippingAddress}" />
                    <button type="submit" class="btn btn-primary center-block">購入確定</button>
                </s:form>
                <div class="well">
                     商品代金合計<br>
                    <p class="text-right"><fmt:formatNumber value="${payment*1.08}" pattern="###,###,###"/>円(税込)</p>
                     合計注文数<br>
                    <p class="text-right">${totalOrders}点</p>
                </div>
            </div>
        </div>

    </div>

    <div class="col-xs-12">
        <div class="panel panel-defalut">
            <div class="panel-heading">ご注文の商品</div>
            <div class="panel-body">
                <s:iterator value="cartList">
                <div class="table-responsive" >
                    <table class="table">
                        <tr>
                            <td style="">
                                <div class="col-xs-12" style="min-width:400px;height:170px;">
                                    <div class="col-xs-3">
                                        <img src="./img/Product/<s:property value="itemImg01"/>"class="img-responsive" alt="" style="height: 150px; width: 150px; margin-top:10px;">
                                    </div>
                                    <div class="col-xs-9" style="padding:0; margin-top:-20px;">
                                        <h3 style="white-space: normal;"><s:property value="itemName"/></h3><br>
                                        <p><b>価格：<fmt:formatNumber value="${subtotal*1.08}" pattern="###,###,###"/>円(税込)</b></p>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
                </s:iterator>
            </div>
        </div>
    </div>



  </div>

</body>
</html>