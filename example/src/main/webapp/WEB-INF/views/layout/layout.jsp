<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<div align="center">
		<div>
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>
		<div>
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
		<div>
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>
</body>
</html>