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
      <div class="col-xs-12 col-sm-12" style="">
        <jsp:include page="header.jsp" /></div>
    </div>
    <%--ヘッダー --%>

    <div class="col-xs-12 col-sm-12 col-lg-9">
        <span style="color:#ff0000;"><s:property value="%{errorMessage}"/></span>
        <s:form action="SettlementConfirmationAction">
            <div class="form-group">
                <div class="col-xs-3">
                    <label style="padding-top:60px;">カードの種類を選んでください。</label>
                </div>
                <div class="col-xs-9">
                <label><input type="radio" name="creditBrand" value="1"><img src="./img/visa.png" style="width:150px;"></label>
                <label><input type="radio" name="creditBrand" value="2"><img src="./img/mastercard.png" style="width:150px;"></label>
                <label><input type="radio"name="creditBrand" value="3"><img src="./img/amex.png" style="width:150px;"></label>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-3 col-xs-offset-2">
                    <label>カード番号</label>
                </div>
                    <input type="text" name="creditNumber"  maxlength="16" pattern="^([0-9]{15,16})$"required value="<s:property value="%{creditNumber}"/>" >
            </div>
            <div class="form-group">
                <div class="col-xs-3 col-xs-offset-2">
                    <label>有効期限</label>
                </div>
                    <select  name="expirationMonth"  required>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select >月
                    <select  name="expirationYear" required>
                        <option value="17">17</option>
                        <option value="17">18</option>
                    </select>年
            </div>

            <div class="form-group">
                <div class="col-xs-5 col-sm-4 col-sm-offset-1 col-lg-3 col-lg-offset-2">
                    <label>セキュリティーコード</label>
                </div>
                    <input type="password" name="securityCode" maxlength="4"  size="10" pattern="^([0-9]{3,4})$"required >
            </div>

            <div class="form-group">
                <div class="col-xs-3 col-xs-offset-2">
                    <label>カード名義</label>
                </div>
                    <input type="text" name="name" maxlength="40"required value="<s:property value="%{name}"/>" pattern="[A-Z| ]+$">
            </div>

            <div class="form-group">
               <div class="col-xs-3 col-xs-offset-2">
                    <label>お届け先の住所</label>
                </div>
                    <input type="text" name="shippingAddress" maxlength="60"  size="40" required value="<s:property value="%{shippingAddress}"/>">
            </div>
            <div class="col-xs-12">
                <button  type="submit" class="btn btn-primary center-block ">入力内容を確認</button>
            </div>

        </s:form>
    </div>
              <div class="col-xs-12 col-sm-12 col-lg-3">
                  <div class="panel panel-default">
                      <div class="panel-heading" style="background:#fde8d0">
                          <div class="well">
                              商品代金合計<br>
                              <p class="text-right"><fmt:formatNumber value="${payment*1.08}" pattern="###,###,###"/>円(税込)</p>
                              合計注文数<br>
                              <p class="text-right">${totalOrders}点</p>
                          </div>
                      </div>
                  </div>
              </div>





  </div>

</body>
</html>