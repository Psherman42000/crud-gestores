package classes;

public class Gestor {

	private String nome;
	private String matricula;
	private String dataNascimento;
	private String setor;
	
	public Gestor() {
	
	}
	
	public Gestor(String nome, String matricula, String dataNasc, String setor) {
		this.nome=nome;
		this.matricula=matricula;
		dataNascimento=dataNasc;
		this.setor=setor;
	}
	
	public void atualizarGestor(String nome, String matricula, String dataNasc, String setor) {
		this.nome=nome;
		this.matricula=matricula;
		dataNascimento=dataNasc;
		this.setor=setor;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDataNascimento() {
		return this.dataNascimento;
	}
	
	public String getSetor() {
		return this.setor;
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public void setMatricula(String matricula) {
		this.matricula=matricula;
	}
	
	public void setDataNascimento(String dataNasc) {
		dataNascimento=dataNasc;
	}
	
	public void setSetor(String setor) {
		this.setor=setor;
	}
}
