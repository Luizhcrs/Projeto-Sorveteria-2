package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SORVETE")
public class Sorvete {
	@Id
	@Column(name = "NOME", nullable = false)
	private String nome;
	@Column(name = "SABOR", nullable = false)
	private String sabor;
	@Column(name = "FABRICANTE", nullable = false)
	private String fabricante;

	@Override
	public String toString() {
		return "Sorvete [nome=" + nome + ", sabor=" + sabor + ", fabricante=" + fabricante + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

}
