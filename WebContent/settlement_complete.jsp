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

    <div class="col-xs-12">
        <div class="panel panel-success" style="margin-top:100px;">
            <div class="panel-heading">
                <h2>ご注文の完了</h2>
            </div>
            <div class="panel-body">
                <p class="text-center text-danger">クレジットカード決済が完了しました。</p>
                <p class="text-center">ご注文いただき、誠にありがとうございました。</p>
                <a href="main_top.jsp" class="btn btn-success center-block" style="width:200px; margin-top:50px;" role="button">トップページに戻る</a>
            </div>
        </div>

    </div>





  </div>

</body>
</html>