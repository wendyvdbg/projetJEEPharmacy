<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pharmacie</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container ">
		<div class="d-flex ">
			<h1 class="mx-auto">Authentification</h1>
		</div>
		<c:if test="${requestScope.errorLogin}" var="variable">
			<div class="alert alert-danger mb-2" role="alert">
				<p>Email ou mot de passe incorrecte !</p>
			</div>
		</c:if>
		<form action="Authentification" method="post">
			<div class="form-group">
				<input type="email" class="form-control" id="email" name="email"
					placeholder="email">
			</div>
			<div class="form-group ">
				<input type="password" class="form-control " id="password"
					name="password" placeholder="password">
			</div>
			<div class="d-flex ">
				<button type="submit" class="btn btn-primary mx-auto mt-2">Connexion</button>
			</div>
		</form>
	</div>
</body>
</html>