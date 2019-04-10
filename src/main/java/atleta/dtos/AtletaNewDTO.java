package atleta.dtos;

import java.io.Serializable;

public class AtletaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private Integer modalidade;
	private Integer competicaoId;

	public AtletaNewDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getModalidade() {
		return modalidade;
	}

	public void setModalidade(Integer modalidade) {
		this.modalidade = modalidade;
	}

	public Integer getCompeticaoId() {
		return competicaoId;
	}

	public void setCompeticaoId(Integer competicaoId) {
		this.competicaoId = competicaoId;
	}

}