<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<%@include file="base-head.jsp"%>
<title>CRUD Manager - Inserir Gerente</title>
</head>
<body>
	<%@include file="nav-menu.jsp"%>

	<div id="container" class="container-fluid">
		<h3 class="page-header">${action eq "insert" ? "Adicionar" : "Editar"}
			Gerente</h3>

		<form action="${pageContext.request.contextPath}/manager/${action}"
			method="POST">

			<input type="hidden" name="manager_id"
				value="${managerToEdit.getId()}">

			<div class="row">
				<div class="form-group col-md-6">
					<label for="content">Nome</label> <input type="text"
						class="form-control" id="manager_name" name="manager_name"
						autofocus="autofocus" placeholder="Nome do Gerente" required
						oninvalid="this.setCustomValidity('Por favor, informe o Nome do gerente')"
						oninput="setCustomValidity('')" value="${managerToEdit.getName()}">
				</div>

				<div class="form-group col-md-6">
					<label for="content">Email</label> <input type="email"
						class="form-control" id="manager_email" name="manager_email"
						autofocus="autofocus" placeholder="Email do Gerente" required
						oninvalid="this.setCustomValidity('Por favor, informe o Email do gerente')"
						oninput="setCustomValidity('')"
						value="${managerToEdit.getEmail()}">
				</div>

				<div class="form-group col-md-6">
					<label for="content">Telefone</label> <input type="text"
						class="form-control" id="manager_fone" name="manager_fone"
						autofocus="autofocus" placeholder="Telefone do Gerente" required
						oninvalid="this.setCustomValidity('Por favor, informe o Telefone do gerente.')"
						oninput="setCustomValidity('')" value="${managerToEdit.getFone()}">
				</div>

				<div class="form-group col-md-4">
					<label for="manager_sexo">Sexo</label> <select id="manager_sexo"
						class="form-control selectpicker" name="manager_sexo" required
						oninvalid="this.setCustomValidity('Por favor, informe o sexo')"
						oninput="setCustomValidity('')">
						<option value="" disabled ${not emptymanagerToEdit ? "" : "selected"}>Selecione
							o sexo</option>
						<option value="F"
							${managerToEdit.getGender() == 'F' ? "selected" : ""}>Feminino</option>
						<option value="M"
							${managerToEdit.getGender() == 'M' ? "selected" : ""}>Masculino</option>
					</select>
				</div>


				<div class="form-group col-md-6">
					<label for="manager_company">Empresa</label> <select
						id="manager_company" class="form-control selectpicker"
						name="manager_company" required
						oninvalid="this.setCustomValidity('Por favor, informe a Empresa.')"
						oninput="setCustomValidity('')">
						<option value=""disabled ${notemptymanagerToEdit ? "" : "selected"}>Selecione
							uma empresa</option>
						<c:forEach var="company" items="${companies}">
							<option value="${company.getId()}"
								${managerToEdit.getCompany().getId() eq company.getId() ? "selected" : ""}>
								${company.getName()}</option>
						</c:forEach>
					</select>
				</div>


			</div>

			<hr />

			<div id="actions" class="row pull-right">
				<div class="col-md-12">
					<a href="${pageContext.request.contextPath}/managers"
						class="btn btn-default">Cancelar</a>
					<button type="submit" class="btn btn-primary">${action eq "insert" ? "Criar" : "Editar"}
						Gerente</button>
				</div>
			</div>

		</form>
	</div>

	<!-- IMPORTAR OS SCRIPTS -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>