<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<link href="/HoneyComb/page_layout/home.css" rel="stylesheet" type="text/css" />



</head>
<body>

	<div id="page_container">

		<div id="page_header">

			<tiles:insertAttribute name="header" />

		</div>
		
	<div id ="page_center_contents_more">
	
		<div id="page_sidebar_more">

			<tiles:insertAttribute name="menu" />

		</div>

		<div id="page_content_more">

			<tiles:insertAttribute name="body" />
			
		</div>
	</div>
	
	
		<div id="page_footer">

			<tiles:insertAttribute name="footer" />

		</div>

	</div>

</body>
</html>