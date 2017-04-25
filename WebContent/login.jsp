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
<link rel="stylesheet" href="./css/login.css">
<%--共通jsの読み込み --%>
<%-- <script src="./js/login.js"></script> --%>
<title>Template</title>
</head>
<body>
    <div class="container">
        <%--　ヘッダー --%>
        <div class="row">
            <div class="col-xs-12 col-sm-12" >
                <jsp:include page="header.jsp" /></div>
            </div>
            <%--ヘッダー --%>
            <div class="col-xs-12 col-sm-12">
                <div class="login-container">
                    <div id="output"></div>
                    <div class="avatar"></div>
                    <div class="form-box">

                        <p style="color:red;"><s:property value="errorMsg"/></p>
                        <s:form action="LoginAction">
                            <input name="email" type="text" placeholder="メールアドレス">
                            <input  name="password" type="password" placeholder="password">
                            <button class="btn btn-info btn-block login" type="submit">ログイン</button>
                        </s:form>
                     </div>
                </div>
            </div>



    <%--フッター(ただの文字　未完成) --%>
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