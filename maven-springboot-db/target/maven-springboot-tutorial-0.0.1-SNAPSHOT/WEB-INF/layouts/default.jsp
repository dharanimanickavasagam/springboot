<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><tiles:insertAttribute name="title" /></title>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextRoot}/css/main.css" rel="stylesheet">
</head>


<body>
	<!-- Static navbar copied from bootstrap 3.3.6 -->
	<nav class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<a class="navbar-brand" href="/">Spring Boot Tutorial</a>
		</div>


		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${contextRoot}/">Home</a></li>
				<li><a href="${contextRoot}/about">About</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="${contextRoot}/addstatus">Add Status</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>



	<div class="container">

		<!--  check this out from apache tiles website -->
		<!--  this variates the content according to the tiles  -->
		<tiles:insertAttribute name="content" />

	</div>





	<script src="https://code.jquery.com/jquery-3.3.1.min.js"</script>
	<script src="${contextRoot}/js/bootstrap.min.js"></script>
</body>
</html>