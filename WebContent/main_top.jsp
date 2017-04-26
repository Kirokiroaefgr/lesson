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
<link rel="stylesheet" href="./css/main_top.css">
<%--共通jsの読み込み --%>
<script src="./js/jqdrawbsgrid.js"></script>
<title>トップページ</title>
</head>
<body>
	<div class="container">
		<%--　ヘッダー --%>
		<div class="row" style="margin-bottom:-15px;">
			<div class="col-xs-12 col-sm-12" >
				<jsp:include page="header.jsp" /></div>
		</div>
		<%--ヘッダー --%>
    <div class="jumbotron" style="margin-top: -15px; height:300px; background: rgba(255,255,255,.0);color:#00a497;">
      <div class="container">
        <h1>LESSON</h1>
       <h3>プログラムの学習に関する書籍を販売するサイトです。</h3>
      </div>
    </div>


	</div>

</body>
</html>