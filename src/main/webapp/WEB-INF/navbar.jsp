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
	<ul>
		<li><a class="active" href="/JEE/Articles">Accueil</a></li>
		<li class="d-flex justify-content-end" style="width: 91vw">
			<form class="d-flex me-4" action="Article" method="get">
				<input type="text" class="form-control my-2" id="articleName" name="articleName"
					placeholder="Rechercher">
				<button type="submit" class="btn btn-outline-light  my-2">Rechercher</button>
			</form> <c:if
				test="${ !empty sessionScope.connected && sessionScope.connected }">

				<form action="Authentification" method="post">
					<input type="text" class="form-control d-none" id="deconnexion"
						name="deconnexion" value="deconnexion">
					<button type="submit" class="btn btn-danger my-2">Déconnexion</button>
				</form>

			</c:if>
		</li>
	</ul>

</body>
</html>