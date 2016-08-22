<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<link href="/HoneyComb/page_layout/home.css" rel="stylesheet"
	type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<div id="page_container">

		<div id="page_header">

			<tiles:insertAttribute name="header" />

		</div>

		<div id="page_sidebar">

			<tiles:insertAttribute name="menu" />

		</div>

		<div id="page_content">

			<tiles:insertAttribute name="body" />
			
		</div>

		<div id="page_footer">

			<tiles:insertAttribute name="footer" />

		</div>

	</div>

</body>
</html>