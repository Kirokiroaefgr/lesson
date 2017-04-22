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
<title>Template</title>
</head>
<body>
	<div class="container">
		<%--　ヘッダー --%>
		<div class="row">
			<div class="col-xs-12 col-sm-12" style="background: #fff;">
				<jsp:include page="header.jsp" /></div>
		</div>
		</div>
		<%--ヘッダー --%>
    <div class="container">
        <div class="row">

            <div class="col-xs-3">
                <div class="panel panel-primary">
                    <div class="panel-heading text-center">
                        <h2 class="panel-title">mymenu</h2>
                    </div>
                    <div class="panel-body">
                        <ul class="nav nav-pills nav-stacked">
                            <li><a  data-toggle="tab" href="#user"><i class="glyphicon glyphicon-pencil"></i> 登録情報</a></li>
                            <li><a  data-toggle="tab" href="#pu"><i class="glyphicon glyphicon-download"></i> 購入履歴</a></li>
                            <li><a  data-toggle="tab" href=""><i class="glyphicon glyphicon-leaf"></i> お気に入り</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-xs-9">
                <div class="tab-content">
                    <div id="user" class="tab-pane fade in active">
                    <s:iterator value="userList">
                    <div class="panel panel-default">
                        <div class="panel-heading text-center">
                            <h2 class="panel-title">ユーザー情報</h2>
                        </div>
                        <div class="panel-body">
                            <table class="table" style="border:none;">
                                <tbody>
                                    <tr>
                                        <th style="border:none;">名前(漢字)</th>
                                        <td><s:property value="familyNameKanji" />  <s:property value="givenNameKanji" /></td>
                                    </tr>

                                    <tr>
                                        <th>名前(カタカナ)</th>
                                        <td><s:property value="familyNameKana" />  <s:property value="givenNameKana" /></td>
                                    </tr>

                                    <tr>
                                        <th>性別</th>
                                        <td><s:property value="sex" /></td>
                                    </tr>

                                    <tr>
                                        <th>生年月日</th>
                                        <td><s:property value="birthday" /></td>
                                    </tr>

                                    <tr>
                                        <th>メールアドレス</th>
                                        <td><s:property value="email" /></td>
                                    </tr>

                                    <tr>
                                        <th>郵便番号</th>
                                        <td><s:property value="postal" /></td>
                                    </tr>

                                    <tr>
                                        <th>住所</th>
                                        <td><s:property value="address" /></td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                    </s:iterator>
                    </div>



                    <div id="pu" class="tab-pane fade">

                    </div>

                </div>
            </div>

        </div>
    </div>



		<%--フッター(ただの文字　未完成) --%>
		<div class="">
		<div class="row">
			<div class="col-xs-12 col-sm-12 text-center"
				style="background: #fff;">
				<hr class="style-one">
				<h1 style="margin: 3rem auto;">会社概要 利用規約</h1>
			</div>
		</div>
		<%--フッター --%>
	</div>

</body>
</html>