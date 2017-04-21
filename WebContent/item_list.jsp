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
<!-- <link rel="stylesheet" href="./css/back.css"> -->
<%--共通jsの読み込み --%>
<%-- <script src="./js/main.js"></script> --%>
<title>商品一覧</title>
</head>
<body style="background:#fff;">
	<div class="container">
		<%--　ヘッダー --%>
		<div class="row">
			<div class="col-xs-12 col-sm-12" >
				<jsp:include page="header.jsp" /></div>
		</div>
		</div>
		<%--ヘッダー --%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-2" style="background: #fff; ,min-height:700px;">
			<div class="well well-sm">コンピューター・IT</div>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    カテゴリー
                </div>
                <!-- <div class="panel-body"> -->
                <ul class="nav nav-pills nav-stacked">
                    <s:iterator value="genreList">
                        <li><a href=""><i class="glyphicon glyphicon-pencil"></i> <s:property value="%{itemGenre}"/></a></li>
                    </s:iterator>
                </ul>
                <!-- </div> -->
               <div class="panel-body">条件を絞り込んで探す</div>
                  <p class="text-center"> 価格(税込み)</p>
                  <ul class="nav nav-pills nav-stacked">
                    <li><a href=""><i class="glyphicon glyphicon-pencil"></i> 0円~1,000円</a></li>
                    <li><a href=""><i class="glyphicon glyphicon-download"></i> 1,001円~2,000円</a></li>
                    <li><a href=""><i class="glyphicon glyphicon-leaf"></i> 2,001円~5,000円</a></li>
                    <li><a href=""><i class="glyphicon glyphicon-folder-open"></i> 5,001円~</a></li>
                </ul>
            </div>
			</div>
			<div class="col-xs-12 col-sm-10" style="background: #fff; min-height:700px;">
			  <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">Home</a></li>
          <li class="breadcrumb-item"><a href="#">コンピューター・IT</a></li>
          <li class="breadcrumb-item active">java</li>
        </ol>

        <div class="panel panel-default">
          <div class="panel-heading">
              並べ替え : おすすめ順 | 新着順 | 価格の安い順 | 価格の高い順 | 売れ筋順
          </div>
          <div class="panel-body">
            <div class="row">
                <div class="col-xs-12 col-sm-2">
                    <div class="thumbnail" style="text-align:center;padding-top:10px;">
                        <a href="">
                            <img src="./img/noImage.png"class="img-responsive" alt="" style="height: auto; width: auto; min-height: 150px; min-width: 150px;">
                        </a>
                        <div class="caption">
                            <p><b>すっきりわかるJava入門</b></p>
                            <p>aaaaaaaa</p>
                            <p style="margin-bottom:0px"><a href="" class="btn btn-warning">カートへ</a></p>
                        </div>
                    </div>
                </div>








            </div>
          </div>
          <div class="panel-footer">ページネーション</div>
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