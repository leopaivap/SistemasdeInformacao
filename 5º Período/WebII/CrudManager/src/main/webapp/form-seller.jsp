<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<%@include file="base-head.jsp"%>
<title>CRUD Manager - Inserir Vendedor</title>
</head>
<body>
	<%@include file="nav-menu.jsp"%>

	<div id="container" class="container-fluid">
		<h3 class="page-header">${action eq "insert" ? "Adicionar" : "Editar"}
			Vendedor</h3>

		<form action="${pageContext.request.contextPath}/seller/${action}"
			method="POST">

			<input type="hidden" name="seller_id" value="${sellerToEdit.getId()}">

			<div class="row">
				<div class="form-group col-md-6">
					<label for="content">Nome</label> <input type="text"
						class="form-control" id="seller_name" name="seller_name"
						autofocus="autofocus" placeholder="Nome do Vendedor" required
						oninvalid="this.setCustomValidity('Por favor, informe o Nome do vendedor.')"
						oninput="setCustomValidity('')" value="${sellerToEdit.getName()}">
				</div>

				<div class="form-group col-md-6">
					<label for="content">Email</label> <input type="email"
						class="form-control" id="seller_email" name="seller_email"
						autofocus="autofocus" placeholder="Email do Vendedor" required
						oninvalid="this.setCustomValidity('Por favor, informe o Email do vendedor.')"
						oninput="setCustomValidity('')" value="${sellerToEdit.getEmail()}">
				</div>

				<div class="form-group col-md-6">
					<label for="content">Telefone</label> <input type="text"
						class="form-control" id="seller_fone" name="seller_fone"
						autofocus="autofocus" placeholder="Telefone do Vendedor" required
						oninvalid="this.setCustomValidity('Por favor, informe o Telefone do vendedor.')"
						oninput="setCustomValidity('')" value="${sellerToEdit.getFone()}">
				</div>

				<div class="form-group col-md-6">
					<label for="seller_company">Empresa</label> <select
						id="seller_company" class="form-control selectpicker"
						name="seller_company" required
						oninvalid="this.setCustomValidity('Por favor, informe a Empresa.')"
						oninput="setCustomValidity('')">
						<option value=""disabled ${notemptysellerToEdit ? "" : "selected"}>Selecione
							uma empresa</option>
						<c:forEach var="company" items="${companies}">
							<option value="${company.getId()}"
								${sellerToEdit.getCompany().getId() eq company.getId() ? "selected" : ""}>
								${company.getName()}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<hr />

			<div id="actions" class="row pull-right">
				<div class="col-md-12">
					<a href="${pageContext.request.contextPath}/sellers"
						class="btn btn-default">Cancelar</a>
					<button type="submit" class="btn btn-primary">${action eq "insert" ? "Criar" : "Editar"}
						Vendedor</button>
				</div>
			</div>

		</form>
	</div>

	<!-- IMPORTAR OS SCRIPTS -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>