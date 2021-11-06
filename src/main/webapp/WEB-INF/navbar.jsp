<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}
</style>
</head>
<body>
	<ul class="d-flex">
		<li><a class="active" href="/JEE/Articles">Accueil</a></li>

		<c:if
			test="${ !empty sessionScope.connected && sessionScope.connected }">
			<li class="ms-auto me-2">
				<form action="Authentification" method="post" class="mt-1">
					<input type="text" class="form-control d-none" id="deconnexion" name="deconnexion"
						value="deconnexion">
					<button type="submit" class="btn btn-danger ">Déconnexion</button>
				</form>
			</li>
		</c:if>
	</ul>

</body>
</html>