<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Fakebook</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-icons.css">
</head>

<body>
	<main class="container">

		<div class="row">
			<h1 class="col-md-8">Usuários</h1>
		</div>

		<div class="row">
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nome</th>
						<th scope="col">Sexo</th>
						<th scope="col">E-mail</th>
					</tr>
				</thead>
				
				<tbody>

					<c:forEach var="user" items="${usuarios}">
						<tr>
							<td>${user.getId()}</th>
							<td>${user.getName()}</td>
							<td>${user.getGender()}</td>
							<td>${user.getEmail()}</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
			
		</div>
		<a href="form_user.html" class="btn btn-primary">Novo Usuário</a>

	</main>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>


</html>