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
<%--bootstrapの読み込み --%>
<link rel="stylesheet"
	href="./css/bootstrap.min.css">
	<%--個別cssの読み込み --%>
<link rel="stylesheet" href=" ./css/header.css">
<title>header</title>
</head>
<body>

    <nav class="navbar navbar-inverse" role="navigation" style="background: rgba(254,179,118,.7);border-color:rgba(255,255,255,.5);">
        <div class="container-fuild">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href='<s:url action="MainTopAction"></s:url>'><img src="./img/lesson.png" alt="hogehoge" class="img-responsive"></a>
            </div>

            <div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href='<s:url action="MainTopAction"></s:url>'><span class="glyphicon glyphicon-home" aria-hidden="true"></span> HOME</a></li>
                    <li><a href='<s:url action="ItemListAction"></s:url>'><span class="glyphicon glyphicon-gift"aria-hidden="true"></span> 商品</a></li>


                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href='<s:url action="CartInsertAction"></s:url>'><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>カート</a></li>
                    <s:if test="#session.userId != null">
                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                <span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span>ようこそ！<s:property value="#session.name" />さん <span class="caret"></span>
                            </a>
                           <ul class="dropdown-menu">
                                <li><a href='<s:url action="MypageAction"></s:url>'><span class="glyphicon glyphicon-user" aria-hidden="true"></span>マイページ</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href='<s:url action="LogOutAction"></s:url>'><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>ログアウト</a></li>
                            </ul>
                        </li>
                    </s:if>
                    <s:else>
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>ログイン</a></li>
                    </s:else>
                </ul>
            </div>
        </div>
    </nav>


    <script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
</body>
</html>