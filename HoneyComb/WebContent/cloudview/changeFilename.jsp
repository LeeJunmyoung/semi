<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="/HoneyComb/cloudview/cloudScript.js" type="text/javascript"></script>
<script>
window.opener.location.reload();
</script>
<title>Insert title here</title>
</head>
<body>
	중복::${param.dupli} 파일경로:: ${file_path} 새로운 파일이름을 입력해주세요
	<form action="/HoneyComb/cloud/cloudRenameItem.cloud" method="post"
		onsubmit="emptyck('itemName')">
		새로운 파일이름을 입력해주세요<br> <input type="text" name="itemName"
			id="itemName"> <input type="submit" value="확인">
			<input type="hidden" name="promgr_num" value="${param.promgr_num}">

		<c:if test="${param.dupli == 'y'}">
	취소버튼을 누를경우 파일이 업로드 되지 않습니다
	<a href="/HoneyComb/cloud/cloudDeleteItem.cloud">취소</a>
		</c:if>
		<c:if test="${!dupli == 'y'}">
	취소버튼을 누를경우 파일이름은 유지됩니다.
	<a href="javascript:close();">취소</a>
		</c:if>
		<c:if test="${param.type =='close'}">
			<script>
				window.close();
			</script>
		</c:if>

	</form>
</body>
</html>