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
	<div class="container">
		<c:if
			test="${requestScope.article.id == null && ! not empty requestScope.article.id }">
			<div class="d-flex ">
				<h1 class="mx-auto mt-5">Ajout d'un article</h1>
			</div>
		</c:if>
		<c:if
			test="${requestScope.article.id != null && not empty requestScope.article.id }"
			var="variable">
			<div class="d-flex ">
				<h2 class="mx-auto mt-5">Edition de l'article
					${requestScope.article.title}</h2>
			</div>
		</c:if>
		<form action="articleForm" method="post">
			<div class="form-group">
				<input type="text" class="form-control d-none" id="id" name="id"
					placeholder="id" value="${requestScope.article.id}">
			</div>
			<div class="form-group">
				<label for="title">Titre</label> <input type="text"
					class="form-control" id="title" name="title" placeholder="Titre"
					value="${requestScope.article.title}">
			</div>
			<div class="form-group">
				<label for="quantity">Quantité</label> <input type="number"
					class="form-control" id="quantity" name="quantity"
					value="${requestScope.article.quantity}" placeholder="Quantité">
			</div>
			<div class="form-group">
				<label for="price">Prix</label> <input type="text"
					value="${requestScope.article.price}" class="form-control"
					id="price" name="price" placeholder="Prix">
			</div>

			<c:choose>
				<c:when
					test="${requestScope.article.id != null && not empty requestScope.article.id }">
					<div class="d-flex ">
						<button type="submit" class="btn btn-primary mx-auto mt-2">Modifier</button>
					</div>
				</c:when>
				<c:otherwise>
					<div class="d-flex ">
						<button type="submit" class="btn btn-primary mx-auto mt-2">Créer</button>
					</div>
				</c:otherwise>
			</c:choose>
		</form>
	</div>
</body>
</html>