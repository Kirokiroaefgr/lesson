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
			        <div class="well well-sm">
			            <s:if test="itemGenre!=null"><s:property value="%{itemGenre}"/></s:if>
			            <s:else>コンピューター・IT</s:else>
			        </div>
              <div class="panel panel-primary">
                  <div class="panel-heading"> カテゴリー</div>
                  <ul class="nav nav-pills nav-stacked">
                      <li><a href='<s:url action="ItemListAction"></s:url>'> &lt;コンピューター・IT</a></li>
                      <s:iterator value="genreList">
                          <li><a href='<s:url action="ItemListAction"><s:param name="itemGenre" value="%{itemGenre}"/></s:url>'>
                              <s:if test='choiceGenre==itemGenre'>&lt;</s:if><s:else><i class="glyphicon glyphicon-book"></i></s:else> <s:property value="%{itemGenre}"/></a>
                          </li>
                      </s:iterator>
                  </ul>
                  <div class="panel-body">条件を絞り込んで探す</div>
                  <p class="text-center"> 価格</p>
                  <ul class="nav nav-pills nav-stacked">
                     <li><a href='<s:url action="ItemListAction"><s:param name="itemGenre" value="%{itemGenre}"/><s:param name="amountSearch" value="1"/></s:url>'><i class="glyphicon glyphicon-usd"></i> 0円~1,000円</a></li>
                     <li><a href='<s:url action="ItemListAction"><s:param name="itemGenre" value="%{itemGenre}"/><s:param name="amountSearch" value="2"/></s:url>'><i class="glyphicon glyphicon-usd"></i> 1,001円~2,000円</a></li>
                     <li><a href='<s:url action="ItemListAction"><s:param name="itemGenre" value="%{itemGenre}"/><s:param name="amountSearch" value="3"/></s:url>'><i class="glyphicon glyphicon-usd"></i> 2,001円~5,000円</a></li>
                     <li><a href='<s:url action="ItemListAction"><s:param name="itemGenre" value="%{itemGenre}"/><s:param name="amountSearch" value="4"/></s:url>'><i class="glyphicon glyphicon-usd"></i> 5,001円~</a></li>
                  </ul>
              </div>
          </div>
          <div class="col-xs-12 col-sm-10" style="background: #fff; min-height:700px;">
              <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="main_top.jsp">Home</a></li>
                  <li class="breadcrumb-item"><a href='<s:url action="ItemListAction"></s:url>'>コンピューター・IT</a></li>
                  <s:if test="itemGenre!=null">
                      <li class="breadcrumb-item active"><s:property value="%{itemList.get(0).getItemGenre()}"/></li>
                  </s:if>
              </ol>
          <div class="panel panel-default">
              <div class="panel-heading">
                  <s:if test="itemCount!=0">全<s:property value="itemCount"/>件中<s:property value="minShowingItemCount"/>～<s:property value="maxShowingItemCount"/>件を表示
                      <ul class="list-inline">
                          <li>並べ替え : </li>
                          <li><a href='<s:url action="ItemListAction">
                              <s:param name="itemGenre" value="%{itemGenre}"/>
                              <s:param name="amountSort" value="2"/>
                              <s:param name="amountSearch" value="%{amountSearch}"/></s:url>'>価格の安い順</a>
                          </li>
                          <li>|</li>
                          <li><a href='<s:url action="ItemListAction">
                              <s:param name="itemGenre" value="%{itemGenre}"/>
                              <s:param name="amountSort" value="1"/>
                              <s:param name="amountSearch" value="%{amountSearch}"/></s:url>'>価格の高い順</a>
                          </li>
                      </ul>
                  </s:if>
                  <s:else>商品が見つかりませんでした。</s:else>
              </div>

              <s:if test="itemCount!=0">
                  <div class="panel-body">
                      <div class="row">
                          <s:iterator value="itemList">
                              <div class="col-xs-12 col-sm-2">
                                  <div class="thumbnail" style="padding-top:10px;min-height:420px;">
                                      <a href='<s:url action="ItemDetailAction"><s:param name="itemId" value="%{itemId}"/></s:url>'>
                                      <img src="./img/Product/<s:property value="itemImg01"/>"class="img-responsive" alt="" style="height: auto; width: auto; min-height: 150px; min-width: 150px;">
                                      <div class="caption">
                                          <p><b><s:property value="itemName"/></b></p>
                                          <p><s:property value="itemAuthor"/></p>
                                          <p><fmt:formatNumber value="${price}" />円</p>
                                      </div>
                                      </a>
                                  </div>
                              </div>
                          </s:iterator>
                      </div>
                  </div>

          <!-- ページネーションここから-->
          <div class="panel-footer">
              <s:if test="maxPage>0">
                  <nav aria-label="Page navigation">
                      <ul class="pagination" >
                          <li class=" <s:if test="pageNum<=1">disabled</s:if>">
                              <a  href= '<s:url action="ItemListAction">
                                  <s:param name="itemGenre" value="%{itemGenre}"/>
                                  <s:param name="amountSort" value="%{amountSort}"/>
                                  <s:param name="pageNum" value="1"/>
                                  <s:param name="amountSearch" value="%{amountSearch}"/></s:url>'>最初のページ</a>
                          </li>
                          <s:if test="pageNum<=1"><li class='page-item disabled'><a >前のページへ</a></li></s:if>
                          <s:else><li >
                              <a href= '<s:url action="ItemListAction">
                                  <s:param name="itemGenre" value="%{itemGenre}"/>
                                  <s:param name="pageNum" value="%{pageNum-1}"/>
                                  <s:param name="amountSort" value="%{amountSort}"/>
                                  <s:param name="amountSearch" value="%{amountSearch}"/></s:url>'>前のページへ</a></li>
                          </s:else>
                          <s:iterator value="page" status="st">
                              <li class=' <s:if test="pageNum==page[#st.count-1]">active</s:if>'>
                                  <a  href= '<s:url action="ItemListAction">
                                      <s:param name="itemGenre" value="%{itemGenre}"/>
                                      <s:param name="amountSort" value="%{amountSort}"/>
                                      <s:param name="pageNum" value="%{page[#st.count-1]}"/>
                                      <s:param name="amountSearch" value="%{amountSearch}"/></s:url>'><s:property/></a>
                              </li>
                          </s:iterator>
                          <s:if test="maxPage<=pageNum"><li class="page-item disabled"><a>次のページへ</a></li></s:if>
                          <s:else><li>
                              <a  href= '<s:url action="ItemListAction">
                                  <s:param name="itemGenre" value="%{itemGenre}"/>
                                  <s:param name="amountSort" value="%{amountSort}"/>
                                  <s:param name="pageNum" value="%{pageNum+1}"/>
                                  <s:param name="amountSearch" value="%{amountSearch}"/></s:url>'>次のページへ</a></li>
                          </s:else>
                          <li class=" <s:if test='maxPage<=pageNum'>disabled</s:if>">
                              <a  href= '<s:url action="ItemListAction">
                                  <s:param name="itemGenre" value="%{itemGenre}"/>
                                  <s:param name="amountSort" value="%{amountSort}"/>
                                  <s:param name="pageNum" value="%{maxPage}"/>
                                  <s:param name="amountSearch" value="%{amountSearch}"/></s:url>'>最後のページ（<s:property value="maxPage"/>）</a>
                          </li>
                      </ul>
                  </nav>
              </s:if>
          </div>
          <!-- ページネーションここまで -->
          </s:if>

        </div>
			</div>
		</div>

</div>


</body>
</html>