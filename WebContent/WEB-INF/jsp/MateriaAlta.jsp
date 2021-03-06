<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Formulario de Alta</title>
</head>
<body>
	<%@ include file="Banner.jsp"%>
	<div class="container">
		<h2>Formulario de alta - Materia/Curso</h2>
		<hr />
		<!--Horizantal line divider  <div class="page-header"/> -->
		<div class="row">
			<%@ include file="mostrarInfoMessage.jsp"%>
		</div>
	</div>
	<form method="POST" action="altaMateriaCurso.html">

		<div class="container">
			<div class="row">
				<%@ include file="_frmMateriaCurso.jsp"%>
			</div>
		</div>

		<c:if test="${empty objMateriaCurso.anio} ">
			<fmt:formatDate var="year" value="${now}" pattern="yyyy" />

		</c:if>
	</form>
	<script type="text/javascript">
		var fechaActual = new Date();
		$("input[name=anio]").val(fechaActual.getFullYear());
		document.getElementsByName('anio')[0].value = fechaActual.getFullYear();
	</script>
</body>
</html>