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
<body >
  <div class="container">
    <%-- ヘッダー --%>
    <div class="row">
      <div class="col-xs-12 col-sm-12" style="">
        <jsp:include page="header.jsp" /></div>
    </div>
    <%--ヘッダー --%>

        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
            </ol>

            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="./img/top1.jpg" alt="Image" style="width:100%; height:300px;">
                    <div class="carousel-caption">
                        <h3>lesson</h3>
                        <p></p>
                    </div>
                </div>

                <div class="item">
                    <img src="./img/top2.jpg" alt="Image" style="width:100%; height:300px;">
                    <div class="carousel-caption">
                        <h3>lesson</h3>
                        <p></p>
                    </div>
                </div>
            </div>

            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <div class="container ">
            <h3 class="text-center">おすすめの書籍</h3><br>
            <div class="row">
                <div class="col-sm-2"></div>
                <s:iterator value="displayList">
                <div class="col-xs-12 col-sm-3">
                    <a href='<s:url action="ItemDetailAction"><s:param name="itemId" value="%{itemId}"/></s:url>'>
                    <img src="./img/Product/<s:property value="itemImg01"/>" class="img-responsive" style="width:100%" alt="Image">
                    <p><s:property value="itemName"/></p></a>
                </div>
                </s:iterator>
            </div>
        </div>



  </div>

</body>
</html>