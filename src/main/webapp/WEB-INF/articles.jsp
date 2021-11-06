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
		<h1 class="mx-auto mt-5">Bienvenue dans le stock de la pharmacie
			Wendy Alexandra Amira</h1>
	</div>
	<div class=" w-100 d-flex">
		<a class=" mt-4 mb-2 ms-auto me-2" href="articleForm"><button
				type="button" class="btn btn-primary ">Ajouter un article</button></a>
	</div>
	<c:if test="${requestScope.successCreation}" var="variable">
		<div class="alert alert-success mb-2" role="alert">
			<p>Article ${requestScope.article.title} créé avec succès</p>
		</div>
	</c:if>
	<c:if test="${requestScope.successUpdate}" var="variable">
		<div class="alert alert-success mb-2" role="alert">
			<p>Article ${requestScope.article.title} mis à jour avec succès</p>
		</div>
	</c:if>
	<c:if test="${requestScope.erreurCreation.length() > 0 }"
		var="variable">
		<div class="alert alert-danger mb-2" role="alert">
			<p>
				<c:out value="${requestScope.erreurCreation }" />
			</p>
		</div>
	</c:if>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Articles</th>
				<th scope="col">Quantité</th>
				<th scope="col">Prix</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.articles}" var="article">
				<tr>
					<td>${article.id}</td>
					<td>${article.title}</td>
					<td>${article.quantity}</td>
					<td>${article.price}</td>
					<td>
						<form action="ArticleForm" method="get">
							<input type="text" class="form-control d-none" id="id" name="id"
								value="${article.id}"> <input type="text"
								class="form-control d-none" id="title" name="title"
								value="${article.title}"> <input type="text"
								class="form-control d-none" id="quantity" name="quantity"
								value="${article.quantity}"> <input type="text"
								class="form-control d-none" id="price" name="price"
								value="${article.price}">
							<button type="submit" class="btn btn-outline-primary ">modifier</button>
						</form>
					</td>
					<td>
						<form action="Articles" method="post">
							<input type="text" class="form-control d-none" id="id" name="id"
								value="${article.id}">
							<button type="submit" class="btn btn-danger ">Supprimer</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>