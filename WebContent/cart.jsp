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
<link rel="stylesheet" href="./css/item_detail.css">
<link rel="stylesheet" href="./css/cart.css">
<%--共通jsの読み込み --%>
<script src="./js/cart.js"></script>
<title>カート</title>
</head>
<body>
	<div class="container">
		<%-- ヘッダー --%>
		<div class="row">
			<div class="col-xs-12 col-sm-12">
				<jsp:include page="header.jsp" /></div>
		</div>
		</div>
		<%--ヘッダー --%>

      <div class="container">
          <div class ="row">
              <div class="col-xs-12">
                  <h1>カート</h1>
                  <hr>
                  <p>注文確定までは、商品の確保はできておりません。<br>※取り寄せ商品は、注文確定後の確認となります。</p>
              </div>

              <div class="col-xs-12 col-sm-9">
                   <h2 style="color:red;"><s:property value="errorMessage"/></h2>
                  <s:if test="cartList.size!=0">
                  <strong>Lessonネットショッピング</strong>
                  <div class="table-responsive" >
                      <table class="table table-hover" >
                          <thead>
                              <tr>
                                  <th>商品名</th>
                                  <th>数量</th>
                                  <th>価格</th>
                              </tr>
                          </thead>
                          <s:iterator value="cartList">
                              <tbody>
                                  <tr>
                                      <td style="">
                                          <div class="col-xs-12" style="min-width:400px;height:170px;">
                                              <div class="col-xs-3">
                                                  <a href="">
                                                      <img src="./img/Product/<s:property value="itemImg01"/>"class="img-responsive" alt="" style="min-height: 70px; min-width: 70px; margin-top:10px;">
                                                  </a>
                                              </div>
                                              <div class="col-xs-9" style="padding:0; margin-top:-20px;">
                                                  <h3 style="white-space: normal;"><s:property value="itemName"/></h3><br>
                                                  <p><b>価格：<fmt:formatNumber value="${subtotal*1.08}" pattern="###,###,###"/>円(税込)</b></p>
                                              </div>
                                          </div>
                                      </td>
                                      <td>

                                          <s:form action="CartInsertAction" id="form01">
                                              <s:hidden name="itemId" value="%{itemId}" />
                                              <div class="row" style="width: 150px;">
                                                  <div class="col-xs-4" style="padding: -5px;">
                                                      <button type="button" class="btn btn-default" onclick="minus('${itemId}')">-</button>
                                                  </div>

                                                  <div class="col-xs-4" style="padding: 0px 0px 0px 3px;">
                                                      <div class="form-group">
                                                          <input type="text" class="form-control" id="${itemId}"name="orderNumber" value="${orderCount}" maxlength="2"pattern="[0-9]*">
                                                      </div>
                                                  </div>

                                                  <div class="col-xs-4" style="padding: 0px 5px;">
                                                      <button type="button" class="btn btn-default"onclick="plus('${itemId}')">+</button>
                                                  </div>
                                              </div>


                                          <div class="col-xs-5" style="padding:0px;">
                                              <button type="submit" id="form01" class="btn btn-primary center-block">更新</button>
                                          </div>
                                          </s:form>
                                          <div class="col-xs-6">
                                          <s:form action="CartDeleteAction">
                                              <s:hidden name="userId" value="%{userId}" />
                                              <s:hidden name="itemId" value="%{itemId}" />
                                              <button type="submit" class="btn btn-default">削除</button>
                                          </s:form>
                                          </div>
                                      </td>
                                      <td style="width: 150px;">価格：<fmt:formatNumber value="${orderCount*subtotal*1.08}" pattern="###,###,###"/>円(税込)</td>
                                  </tr>
                              </tbody>
                          </s:iterator>
                      </table>
                  </div>
                  </s:if>
              </div>

              <div class="col-xs-12 col-sm-3">
                  <div class="panel panel-default">
                      <div class="panel-heading" style="background:#fde8d0">
                      <s:form action="GoSettlementAction">
                          <button type="submit" class="btn btn-warning center-block">ご注文手続きに進む</button></s:form>
                          <div class="well">
                              商品代金合計<br>
                              <p class="text-right"><fmt:formatNumber value="${payment*1.08}" pattern="###,###,###"/>円(税込)</p>
                              合計注文数<br>
                              <p class="text-right">${order}点</p>
                          </div>
                      </div>
                  </div>
              </div>

          </div>
      </div>


		<%--フッター(ただの文字 未完成) --%>
		<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 text-center"
				style="background: rgba(255,255,255,.0);">
				<hr class="style-one">
				<h1 style="margin: 3rem auto;">会社概要 利用規約</h1>
			</div>
		</div>
		<%--フッター --%>
	</div>

</body>
</html>