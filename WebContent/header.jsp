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
<link rel="stylesheet"
	href="./css/bootstrap.min.css">
	<%--個別cssの読み込み --%>
<link rel="stylesheet" href=" ./css/header.css">
<title>header</title>
</head>
<body>

	<nav class="navbar navbar-inverse" style="height:40px;background: rgba(255,255,255,.5); border-color:rgba(255,255,255,.5);">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img
					src="./img/lesson.png" alt="hogehoge" class="img-responsive" 	style="height: 40px; width: auto; min-height: 40px; min-width: auto;"></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav" >
					<li><a href="main_top.jsp"><span style="color:#00a497;">HOME</span></a></li>
					<li><a href="#themes" style="color:#00a497;">商品</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#" style="color:#00a497;"><span class="glyphicon glyphicon-user"></span >マイページ<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#" style="color:#00a497;">ユーザー情報</a></li>
							<li><a href="#" style="color:#00a497;">購入履歴</a></li>
							<li><a href="#">Page 1-3</a></li>
						</ul></li>
					<li><a href="cart.jsp" style="color:#00a497;">
							カート</a></li>
					<li><a href="login.jsp" style="color:#00a497;"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
				</ul>
			</div>
		</div>
	</nav>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="./js/bootstrap.min.js"></script>
</body>
</html>
