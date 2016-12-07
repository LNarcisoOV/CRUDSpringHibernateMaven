<%@ page language="java" isErrorPage="true"	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de produtos!</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/menu/Menu.jsp" />
	
	<h1>Cadastro de produto</h1>
	
	<form action="<c:url value='/produto/salvarProduto'/>" method="post">
		<c:if test="${mensagemTituloProduto != null }">
			<br />
				${mensagemTituloProduto }
			<br /><br />
		</c:if>
		<br />
		Nome: <input type="text" name="nome" /> 
		<br /> 
		Descrição: <textarea name="descricao" rows="4" cols="50"> </textarea><br />
		<br /> 
		Preço: <input type="text" name="preco" id="idPreco" /> <br />
		<br />
		<input type="submit" value="Cadastrar" />
		<br/>
	</form>
	
	<script>
	$(document).ready(function(){
		alert("aaaa");
		$("#idPreco").mask("0000.000,00");
	});
	</script>
</body>
</html>