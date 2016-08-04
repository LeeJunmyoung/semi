<%@ page import="com_bean.HoneyCombDBBean"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="view/color.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>회사 검색</title>
<script>
	function comCheck() {
		if (document.comSearch.com_name.value == "") {
			alert("사업장명을 입력하세요!");
			return false;
		}

		return true;
	}
	function send_com_name(conName,com_num) {
		var sendcom = conName;
		var send_num = com_num;
		opener.document.com_search.com_num.value = com_num;
		opener.document.com_search.com_name.value = sendcom; 
		window.close();
	}

/* 	function resultCheck() {
		var result = com_name + " " + com + add + " " + com + phone;

	} */
</script>
</head>
<body bgcolor="<%=bodyback_c%>">


		<form name="comSearch" method="post" action="/HoneyComb/company/companyCheckPro.company" onsubmit="return comCheck()">
			<tr>
				<td><br> 사업장명 <input type="text" name="com_name">
					<input type="submit" value="찾기" ></td>
				<!-- <table width="300" border="1" cellspacing="0" cellpadding="3"
				align="center"> -->
			</tr>
		</form>
		<c:if test="${ empty comList }">
			<tr>
				<td align="center"><br>검색된 결과가 없습니다</td>
			</tr>
		</c:if>
		<c:if test="${ !empty comList }">
			<tr>
				<td align="center"><br> ※ 아래 회사명을 클릭하면 자동으로 입력됩니다</td>
			</tr>
			<c:forEach var="search" items="${ comList }">
			<br><p>
				<tr>
					<td><a href="javascript:send_com_name('${search.com_name}','${search.com_num}' )" >
							${search.com_name}&nbsp; ${search.com_add}&nbsp; ${search.com_phone}&nbsp;
						
					</a><br></td>
				</tr>
			</c:forEach>
		</c:if>
		<br>
		<tr>
			<td align="center"><br> <a href="javascript:this.close();">닫기</a>
			</td>
		</tr>

		</table>


</body>
</html>
