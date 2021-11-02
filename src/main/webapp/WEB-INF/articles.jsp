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
	<div class=" w-100 d-flex">
		<a class=" mt-4 mb-2 ms-auto me-2" href="articleForm"><button
				type="button" class="btn btn-primary ">Ajouter un article</button></a>
	</div>
	<c:if test="${requestScope.successCreation}" var="variable">
		<div class="alert alert-success mb-2" role="alert">
			<p>Article ${requestScope.article.title} créé avec succès</p>
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
				<th scope="col">Actions</th>
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
						  <form action="Articles" method="post">
                           <input type="text" class="form-control invisible" id="id" name="id" value="${article.id}">
                            <button type="submit" class="btn btn-danger ">Supprimer</button>
                        </form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>