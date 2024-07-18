<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="base-head.jsp"%>
<title>CRUD Manager - Vendedores</title>

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
				<h3>Vendedores</h3>
			</div>

			<div class="col-md-6">
				<div class="input-group h2">
					<input name="data[search]" class="form-control" id="search"
						type="text" placeholder="Pesquisar vendedores"> <span
						class="input-group-btn">
						<button class="btn btn-danger" type="submit">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>

			<div class="col-md-3">
				<a href="/crud-manager/seller/form"
					class="btn btn-danger pull-right h2"><span
					class="glyphicon glyphicon-plus" /></span>&nbspAdicionar Vendedor</a>
			</div>
		</div>

		<hr />

		<div class="row" id="list">
			<div class="table-responsive col-md-12">
				<table class="table table-striped table-hover" cellspacing="0"
					cellpadding="0">
					<thead>
						<tr>
							<th>Nome</th>
							<th>E-mail</th>
							<th>Telefone</th>
							<th>Empresa</th>
							<th>Editar</th>
							<th>Excluir</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="seller" items="${sellers}">
							<tr>
								<td>${seller.getName()}</td>
								<td>${seller.getEmail()}</td>
								<td>${seller.getFone()}</td>
								<td>${seller.getCompany().getName()}</td>

								<td>Editar</td>
								<td>Excluir</td>
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


</body>
</html>