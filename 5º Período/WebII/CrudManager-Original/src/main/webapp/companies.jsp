<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="base-head.jsp"%>
<title>CRUD Manager - Empresas</title>
</head>
<body>
	<%@include file="modal.html"%>
	<%@include file="nav-menu.jsp"%>

	<div id="container" class="container-fluid">
		<div id="alert"
			style="${not empty message ? 'display: block;' : 'display: none;'}"
			class="alert alert-dismissable ${alertType eq 1 ? 'alert-success' : 'alert-danger'}">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			${message}
		</div>

		<div id="top" class="row">
			<div class="col-md-3">
				<h3>Empresas</h3>
			</div>

			<div class="col-md-6">
				<div class="input-group h2">
					<input name="data[search]" class="form-control" id="search"
						type="text" placeholder="Pesquisar empresas"> <span
						class="input-group-btn">
						<button class="btn btn-danger" type="submit">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>

			<div class="col-md-3">
				<a href="/crud-manager/company/form"
					class="btn btn-danger pull-right h2"><span
					class="glyphicon glyphicon-plus" /></span>&nbspAdicionar Empresa</a>
			</div>
		</div>

		<hr />

		<div id="list" class="row">
			<div class="table-responsive col-md-12">
				<table class="table table-striped table-hover" cellspacing="0"
					cellpadding="0">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Cargo</th>
							<th>Início</th>
							<th>Saída</th>
							<th>Usuário</th>
							<th>Editar</th>
							<th>Excluir</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="comp" items="${companies}">
							<tr>
								<td>${comp.getName()}</td>
								<td>${comp.getRole()}</td>
								<td>${comp.getStart()}</td>
								<td>${comp.getEnd()}</td>
								<td>${comp.getUser().getName()}</td>

								<td class="actions"><a class="btn btn-info btn-xs"
									href="${pageContext.request.contextPath}/company/update?companyId=${comp.getId()}">
										<span class="glyphicon glyphicon-edit"></span>
								</a></td>

								<td class="actions"><a
									class="btn btn-danger btn-xs modal-remove"
									company-id="${comp.getId()}" company-name="${comp.getName()}"
									data-toggle="modal" data-target="#delete-modal" href="#"><span
										class="glyphicon glyphicon-trash"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
		<div id="bottom" class="row">
			<div class="col-md-12">
				<ul class="pagination">
					<li class="disabled"><a>&lt; Anterior</a></li>
					<li class="disabled"><a>1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
				</ul>
				<!-- /.pagination -->
			</div>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(
				function() {
					// fecha o alert após 3 segundos
					setTimeout(function() {
						$("#alert").slideUp(500);
					}, 3000);

					// ao clicar no delete de algum post, pega o nome do usuário, 
					// o id do usuário e a ação (delete) e envia para o modal 
					$(".modal-remove").click(
							function() {
								var companyName = $(this).attr('company-name');
								var companyId = $(this).attr('company-id');
								$(".modal-body #hiddenValue").text(
										"a empresa '" + companyName + "'");
								$("#id").attr("value", companyId);
								$("#form").attr("action", "company/delete");
							})
				});
	</script>
</body>
</html>