<%@ page pageEncoding="UTF-8"%>
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
	<%@ include file="navbar.jsp"%>
	<div class="d-flex ">
		<h1 class="mx-auto mt-5">Résultat de la recherche :</h1>
	</div>
	<c:if test="${requestScope.article.id == 0}" var="variable">
		<h2 class="text-center">Aucun article trouvé</h2>
	</c:if>

	<c:if test="${requestScope.article.id > 0}" var="variable">
		<div class="card ms-auto me-auto mt-2" style="width: 18rem;">
			<img
				src="https://valu-medpharmacy.com/wp-content/uploads/sites/28/2018/01/drug.jpg"
				class="card-img-top" alt="pharmacie">
			<div class="card-body text-center">
				<h5 class="card-title">Article - ${article.title}</h5>
				<p class="card-text">Quantité - ${article.quantity}</p>
				<p class="card-text">Prix - ${article.price} €</p>
			</div>
		</div>
	</c:if>

</body>
</html>