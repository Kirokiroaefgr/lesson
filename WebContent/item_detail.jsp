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
                     <li class="breadcrumb-item"><a href="#">Home</a></li>
                     <li class="breadcrumb-item"><a href="#">コンピューター・IT</a></li>
                     <li class="breadcrumb-item active">java</li>
                  </ol>
              </div>

              <div class="col-xs-12 col-sm-3">
                  <div class="row">
                      <div class="col-xs-8 col-xs-offset-2 col-sm-12" style="height:20px;"></div>
                      <div class="col-xs-12 col-sm-12 center-block">
                          <img src='./img/noImage.png'class="img-thumbnail img-responsive center-block MP" style="width: auto; height: auto;">
                      </div>
                      <div class="col-xs-4 col-sm-4" style="padding:0;">
                          <img src='./img/noImage.png' style="width: auto; height: auto;" class="img-thumbnail img-responsive center-block CP" >
                      </div>
                      <div class="col-xs-4 col-sm-4" style="padding:0;">
                          <img src='./img/noImage2.png' style="width: auto; height: auto;" class="img-thumbnail img-responsive center-block CP" >
                      </div>
                      <div class="col-xs-4 col-sm-4" style="padding:0;">
                          <img src='./img/noImage3.png' style="width: auto; height: auto;" class="img-thumbnail img-responsive center-block CP" >
                      </div>
                  </div>
              </div>

              <div class="col-xs-12 col-sm-6">
                  <h2><strong>すっきりわかるjava入門</strong></h2>
                  <table class="table">
                      <tbody>
                          <tr>
                              <th>著者</th>
                              <td>中山清喬  |  国本大悟</td>
                          </tr>

                          <tr>
                              <th>ページ数</th>
                              <td>657ページ</td>
                          </tr>

                          <tr>
                              <th>ISBN</th>
                              <td>978-4-8443-3638-9</td>
                          </tr>

                          <tr>
                              <th>発売日</th>
                              <td>2014年08月</td>
                          </tr>

                          <tr>
                              <th>価格</th>
                              <td>2,600円 （税込：2,808円）</td>
                          </tr>

                      </tbody>
                  </table>
              </div>
              <div class="col-xs-12 col-sm-3" style="margin-top:20px; ">
                  <div class="panel panel-default" style="min-width:200px;">
                      <div class="panel-heading">
                          2,600円 (税込:2,808円)<br>
                          在庫あり
                          <s:form action="CartInsertAction">
                              <s:hidden name="itemId" value="%{itemId}" />
                              <s:hidden name="orderNumber" value="1" />
                              <s:hidden name="detail" value="true" />
                              <button class="btn btn-lg btn-warning btn-block" style="margin:10px 0;" type="submit"<s:if test="stock<=0"></s:if>>カートに入れる</button>
                          </s:form>
                      </div>
                  </div>
              </div>

              <div class="col-xs-12" style="margin-top:20px;">
                  <div class="panel panel-default">
                      <div class="panel-heading">
                          商品説明
                      </div>
                      <div class="panel-body">
                          Javaの「どうして?」「なぜそうなる?」が必ずわかる入門書の決定版! <br>
                          ランキング1位の大人気Java入門書に改訂版登場<br>
                          本書は、Javaの基礎から初学者には難しいとされるオブジェクト指向まで、膨らむ疑問にしっかり対応し、Javaプログラミングの「なぜ?」がわかる解説と約300点の豊富なイラストで、楽しく・詳しく・スッキリとマスターできる構成となっています。
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