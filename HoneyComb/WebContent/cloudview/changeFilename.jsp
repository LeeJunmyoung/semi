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
	�ߺ�::${param.dupli} ���ϰ��:: ${file_path} ���ο� �����̸��� �Է����ּ���
	<form action="/HoneyComb/cloud/cloudRenameItem.cloud" method="post"
		onsubmit="emptyck('itemName')">
		���ο� �����̸��� �Է����ּ���<br> <input type="text" name="itemName"
			id="itemName"> <input type="submit" value="Ȯ��">
			<input type="hidden" name="promgr_num" value="${param.promgr_num}">

		<c:if test="${param.dupli == 'y'}">
	��ҹ�ư�� ������� ������ ���ε� ���� �ʽ��ϴ�
	<a href="/HoneyComb/cloud/cloudDeleteItem.cloud">���</a>
		</c:if>
		<c:if test="${!dupli == 'y'}">
	��ҹ�ư�� ������� �����̸��� �����˴ϴ�.
	<a href="javascript:close();">���</a>
		</c:if>
		<c:if test="${param.type =='close'}">
			<script>
				window.close();
			</script>
		</c:if>

	</form>
</body>
</html>