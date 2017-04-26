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
<%--共通jsの読み込み --%>
<script src="./js/item_detail.js"></script>
<title>商品詳細</title>
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

      <div class="container-fluid">
          <div class ="row">
              <div class="col-xs-12">
                  <ol class="breadcrumb">
                     <li class="breadcrumb-item"><a href="main_top.jsp">Home</a></li>
                     <li class="breadcrumb-item"><a href='<s:url action="ItemListAction"></s:url>'>コンピューター・IT</a></li>
                     <li class="breadcrumb-item active"><a href='<s:url action="ItemListAction"><s:param name="itemGenre" value="%{itemList.get(0).getItemGenre()}"/></s:url>'><s:property value="%{itemList.get(0).getItemGenre()}"/></a></li>
                  </ol>
              </div>

              <div class="col-xs-12 col-sm-3">
                  <div class="row">
                      <s:iterator value="itemList">
                          <div class="col-xs-8 col-xs-offset-2 col-sm-12" style="height:20px;"></div>
                          <div class="col-xs-12 col-sm-12 center-block">
                              <img src='./img/Product/<s:property value="itemImg01"/>'class="img-thumbnail img-responsive center-block MP" style="width: auto; height: auto;">
                          </div>
                          <div class="col-xs-4 col-sm-4" style="padding:0;">
                              <img src='./img/Product/<s:property value="itemImg01"/>' style="width: auto; height: auto;" class="img-thumbnail img-responsive center-block CP" >
                          </div>
                          <s:if test="itemImg02!=null"><div class="col-xs-4 col-sm-4" style="padding:0;">
                              <img src='./img/Product/<s:property value="itemImg02"/>' style="width: auto; height: auto;" class="img-thumbnail img-responsive center-block CP" >
                          </div></s:if>
                          <s:if test="itemImg03!=null"><div class="col-xs-4 col-sm-4" style="padding:0;">
                              <img src='./img/Product/<s:property value="itemImg03"/>' style="width: auto; height: auto;" class="img-thumbnail img-responsive center-block CP" >
                          </div></s:if>
                      </s:iterator>
                  </div>
              </div>

              <div class="col-xs-12 col-sm-6">
                  <s:iterator value="itemList">
                      <h2><strong><s:property value="itemName"/></strong></h2>
                          <table class="table">
                              <tbody>
                                  <tr>
                                      <th>著者</th>
                                      <td><s:property value="itemAuthor"/></td>
                                  </tr>

                                  <tr>
                                      <th>ページ数</th>
                                      <td><s:property value="page"/>ページ</td>
                                  </tr>

                                  <tr>
                                      <th>ISBN</th>
                                      <td><s:property value="isbm"/></td>
                                  </tr>

                                  <tr>
                                      <th>発売日</th>
                                      <td><s:property value="releaseDate"/></td>
                                  </tr>

                                  <tr>
                                      <th>価格</th>
                                      <td><fmt:formatNumber value="${price}" />円 （税込：<fmt:formatNumber value="${price*1.08}" pattern="###,###,###"/>円）</td>
                                  </tr>
                            </tbody>
                       </table>
                   </s:iterator>
              </div>
              <div class="col-xs-12 col-sm-3" style="margin-top:20px; ">
                  <s:iterator value="itemList">
                      <div class="panel panel-default" style="min-width:200px;">
                          <div class="panel-heading">
                              <fmt:formatNumber value="${price}" />円 (税込:<fmt:formatNumber value="${price*1.08}" pattern="###,###,###" />円)<br>
                              在庫あり
                              <s:form action="CartInsertAction">
                                  <s:hidden name="itemId" value="%{itemId}" />
                                  <s:hidden name="orderNumber" value="1" />
                                  <s:hidden name="detail" value="true" />
                                  <button class="btn btn-lg btn-warning btn-block" style="margin:10px 0;" type="submit"<s:if test="stock<=0"></s:if>>カートに入れる</button>
                              </s:form>
                          </div>
                      </div>
                  </s:iterator>
              </div>

              <div class="col-xs-12" style="margin-top:20px;">
                  <s:iterator value="itemList">
                      <div class="panel panel-default">
                          <div class="panel-heading"> 商品説明</div>
                          <div class="panel-body">
                              <s:property value="itemDetail"/>
                          </div>
                       </div>
                   </s:iterator>
               </div>

          </div>
      </div>




</body>
</html>