<%@page import="bd.Conexao"%>
<%@page import="classes.Gestor"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Sistemas de Gestores</title>
	<link rel="stylesheet" href="CSS/estilo.css">
</head>
<body>
	<header class="cabecalho">
		<p>Bem Vindo Ao Sistema De Gerenciamento De Gestores</p>
	</header>
	
	<main>
	
		<div class="centro">
			
			<% 
			
				Conexao con=new Conexao();
				ArrayList<Gestor> gestores=new ArrayList<Gestor>();
				gestores=con.getGestores();
				if(gestores==null)
					out.print("AINDA NÃO HÁ GESTORES CADASTRADOS");
				else{
					out.print("<table>");
					out.print("<tr>");
					out.print("<th>Nome</th>");
					out.print("<th>Matricula</th>");
					out.print("<th>Data de Nascimento</th>");
					out.print("<th>Setor</th>");
					out.print("<th>Editar</th>");
					out.print("<th>Excluir</th>");
					out.print("</tr>");
					for(Gestor gestor:gestores){
						out.print("<tr>");
						out.print("<td>"+gestor.getNome()+"</td>");
						out.print("<td>"+gestor.getMatricula()+"</td>");
						out.print("<td>"+gestor.getDataNascimento()+"</td>");
						out.print("<td>"+gestor.getSetor()+"</td>");
						out.print("<td><a href='Atualizar.jsp?nome="+gestor.getNome()+"&matricula="+gestor.getMatricula()+"&dataNascimento="+gestor.getDataNascimento()+"&setor="+gestor.getSetor()+"'>ATUALIZAR</td>");
						out.print("<td><a href='Excluir.jsp?nome="+gestor.getNome()+"&matricula="+gestor.getMatricula()+"&dataNascimento="+gestor.getDataNascimento()+"&setor="+gestor.getSetor()+"'>EXCLUIR</td>");
						out.print("</tr>");
					}
					out.print("</table>");
				}
			
			%>
			<form action="Cadastro.jsp">
				<input class="btnCadastrar" type="submit" value="Cadastrar Novo Gestor" >
			</form><br><br>
			
		</div>
	
	</main>
	<footer class="rodape">
		<p>Copyleft - 2019 - "all rights reversed"</p>
	</footer>
</body>
</html>