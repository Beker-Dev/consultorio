package br.com.forms;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "cadastrarAluno", urlPatterns = {"/cadastrarAluno"})
public class CadastrarAlunoServlet extends HttpServlet {
	List<Aluno> alunos = new ArrayList<>();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		
		if (alunos.size() > 0) {
			for (int i = 0; i < alunos.size(); i ++) {
				print.println("Aluno: " + alunos.get(i).getNome() + " | Turma: " + alunos.get(i).getTurma() + "<br>");			
			}
		}
		else {
			print.println("Nenhum aluno cadastrado!");
		}

		print.println("<div>" + getCadastrarAlunoHTML() + "</div>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Aluno newAluno = new Aluno();
		newAluno.setNome(request.getParameter("a_nome"));
		newAluno.setTurma(request.getParameter("a_turma"));
		String alunoEditar = request.getParameter("a_editar");
		String alunoExcluir = request.getParameter("a_excluir");
		String alunoEditarNome = request.getParameter("a_editar_nome");
		String alunoEditarTurma = request.getParameter("a_editar_turma");
		PrintWriter print = response.getWriter();
		Boolean alunoExists = false;
		
		if (alunoEditar.length() > 0) {  // if editar
			alunoEditar = alunoEditar.toUpperCase();
			for (int i = 0; i < alunos.size(); i ++) {
				if (alunoEditar.equals(alunos.get(i).getNome())) {
					if (alunoEditarNome.length() > 0) {
						alunoEditarNome = alunoEditarNome.toUpperCase();
						alunos.get(i).setNome(alunoEditarNome);
					}
					if (alunoEditarTurma.length() > 0) {
						alunoEditarTurma = alunoEditarTurma.toUpperCase();
						alunos.get(i).setTurma(alunoEditarTurma);
					}
				}
			}
		}
		else if (alunoExcluir.length() > 0) {  // if excluir
			alunoExcluir = alunoExcluir.toUpperCase();
			for (int i = 0; i < alunos.size(); i ++) {
				if (alunoExcluir.equals(alunos.get(i).getNome())) {
					alunos.remove(i);
				}
			}
		}	
		else {  // if adicionar
			if (newAluno.getNome().length() > 0) {
				newAluno.setNome(newAluno.getNome().toUpperCase());
				for (Aluno aluno : alunos) {
					if (newAluno.getNome().equals(aluno.getNome())) {
						alunoExists = true;
						break;
					}
				}	
				if (! alunoExists) {
					try {
						int turma = Integer.parseInt(newAluno.getTurma());
						alunos.add(newAluno);
				        print.println("Aluno " + newAluno.getNome() + " foi cadastrado com sucesso!");
					}
					catch (Exception e) {
						print.println("Erro: Turma deve conter somente caracteres numericos!");
					}
				}
				else {
					print.println("Erro: Aluno ja esta cadastrado!");
				}		
			}
			else {
				print.println("Erro: Nome do aluno esta vazio!");
			}
		}
		
		response.sendRedirect("aluno.html");
	}
	
	
	public String getCadastrarAlunoHTML() {
		String htmlContent = "<form method='post' action='cadastrarAluno'>" + 
		"<input name='a_nome' placeholder='Nome'><br>" +
		"<input name='a_turma' placeholder='Turma'><br>" +
		"<input name='a_editar' placeholder='Editar byName'><br>" +
		"<input name='a_editar_nome' placeholder='Editar Nome (vazio para continuar o mesmo)'><br>" +
		"<input name='a_editar_turma' placeholder='Editar Turma (vazio para continuar o mesmo)'><br>" +
		"<input name='a_excluir' placeholder='Excluir byName'><br><br>" +
		"<input type='submit' value='Cadastrar Aluno'>" +
		"</form>";
		
		return htmlContent;
	}
	
	public String getEditarAlunoHTML() {
		String htmlContent = "";
		
		
		
		return htmlContent;
	}
}
