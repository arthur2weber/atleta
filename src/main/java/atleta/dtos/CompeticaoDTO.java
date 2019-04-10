package atleta.dtos;
import java.io.Serializable;

import atleta.domain.Competicao;


public class CompeticaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private String data;
	
	public CompeticaoDTO() {
	}

	public CompeticaoDTO(Competicao obj) {
		id = obj.getId();
		descricao = obj.getDescricao();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}