<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Finance Manager</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link href="<c:url value="/resources/static/css/demo.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/static/css/menu.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/static/js/menu.js" />"></script>


	<div id='cssmenu'>
		<ul>
			<li class='rightside'><a href="/user/welcomePage.html"><span>Login as user</span></a></li>
			<li class='rightside'><a href="/admin/welcomePage.html"><span>Login as admin</span></a></li>
		</ul>
	</div>

</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>


<div class="container">
	<div class="jumbotron">


		<h1>Finance Manager</h1>
		<h2>The spending money supporter</h2>


	</div>

	<div class="row">
		<div class="col-sm-4">

			<h3>Spending visualization</h3>

			<img src="resources/static/images/samplechart.PNG" alt="sample chart">

		</div>
		<div class="col-sm-4">
			<h3>Customize your preferences</h3>
		</div>
		<div class="col-sm-4">
			<h3>Something else</h3>
		</div>
	</div>
</div>

</body>
</html>