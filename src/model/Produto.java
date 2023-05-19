package model;

public class Produto {
	
	private int andar;
	private String NomeDp;
	private String Descricao;
	
	public int getAndar() {
		return andar;
	}
	public void setAndar(int andar) {
		this.andar = andar;
	}
	public String getNomeDp() {
		return NomeDp;
	}
	public void setNomeDp(String nomeDp) {
		NomeDp = nomeDp;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "Nome do Departamento: " + NomeDp + " | Descriçao:" + Descricao;
	}
	
	

}
