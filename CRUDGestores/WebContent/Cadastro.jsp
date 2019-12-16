
<%@page import="javafx.scene.web.PromptData"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Sistemas de Gestores : Cadastro</title>
	<link rel="stylesheet" href="CSS/estilo.css">
</head>
<body>
	<header class="cabecalho">
		<p>Bem Vindo Ao Sistema De Gerenciamento De Gestores</p>
	</header>
	
	<main>
	
		<div class="centro">
			<form action="EXCadastrar.jsp" method="post">
				Nome:                              <input type="text" name="nome"><br>
				Matrícula:                         <input type="text" name="matricula"><br>
				Data de Nascimento Ex(dd-mm-yyyy): <input type="text" name="dataNascimento"><br>
				Setor:                             <input type="radio" name="setor" value="T">T
												   <input type="radio" name="setor" value="H">H
												   <input type="radio" name="setor" value="A">A
												   <input type="radio" name="setor" value="R">R<br><br>
				<input class="btnCadastrar" type="submit" value="Cadastrar" >
			</form><br><br>
		</div>
		
	
	</main>
	<footer class="rodape">
		<p>Copyleft - 2019 - "all rights reversed"</p>
	</footer>
</body>
</html>