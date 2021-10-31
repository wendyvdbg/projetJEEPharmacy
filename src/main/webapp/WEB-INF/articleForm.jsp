<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pharmacie</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Pharmacie</h1>
<form action="articleForm" method="post">
<div class="form-group">
<label for="title">Titre</label>
<input type="text" class="form-control" id="title" name="title" placeholder="Titre">
</div>
<div class="form-group">
<label for="quantity">Quantité</label>
<input type="text" class="form-control" id="quantity" name="quantity" placeholder="Quantité">
</div>
<div class="form-group">
<label for="price">Prix</label>
<input type="text" class="form-control" id="price" name="price" placeholder="Prix">
</div>
<button type="submit" class="btn btn-primary">Créer</button>
</form>
</div>
</body>
</html>