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
<body onload="document.form.submit()">
    <s:form action="RedirectItemListAction" name="form">
        <s:hidden name="choiceGenre" value="%{choiceGenre}" />
        <s:hidden name="itemGenre" value="%{itemGenre}" />
        <s:hidden name="pageNum" value="%{pageNum}" />
        <s:hidden name="maxPage" value="%{maxPage}" />
        <s:hidden name="amountSearch" value="%{amountSearch}" />
        <s:hidden name="amountSort" value="%{amountSort}" />
        <s:hidden name="itemCount" value="%{itemCount}" />
        <s:hidden name="maxShowingItemCount" value="%{maxShowingItemCount}" />
        <s:hidden name="minShowingItemCount" value="%{minShowingItemCount}" />

        <s:iterator value="genreList"  status="st">
          <s:hidden name="genreList.itemGenre" value="%{itemGenre}" />
        </s:iterator>

        <s:iterator value="page"  status="st">
          <s:hidden name="page" value="%{page[#st.index]}" />
        </s:iterator>

        <s:iterator value="itemList"  status="st">
          <s:hidden name="itemList.itemName" value="%{itemName}" />
        </s:iterator>
    </s:form>


</body>
</html>