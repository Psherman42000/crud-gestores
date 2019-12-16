<%@page import="bd.Conexao"%>
<%@page import="classes.Gestor"%>

<%@page import="javafx.scene.web.PromptData"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Sistemas de Gestores : EXAtualizar</title>
	<link rel="stylesheet" href="CSS/estilo.css">
</head>
<body>
	<header class="cabecalho">
		<p>Bem Vindo Ao Sistema De Gerenciamento De Gestores</p>
	</header>
	
	<main>
	
		<%
	
			Conexao con=new Conexao();
			Gestor gestor=new Gestor(request.getParameter("nome"), request.getParameter("matricula"), request.getParameter("dataNascimento"), request.getParameter("setor"));
			con.alteraGestor(request.getParameter("matriculaAntiga"), gestor);
			response.sendRedirect("Index.jsp");
		
		%>
		
	
	</main>
	<footer class="rodape">
		<p>Copyleft - 2019 - "all rights reversed"</p>
	</footer>
</body>
</html>