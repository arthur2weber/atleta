package atleta.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import atleta.domain.enums.Modalidade;


@Entity
public class Atleta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Integer modalidade;

	@OneToMany(mappedBy="atleta")
	private List<Inscricao> inscricoes = new ArrayList<>();



	public Atleta() {
	}

	public Atleta(Integer id, String nome, Modalidade modalidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.modalidade = (modalidade==null)?null:modalidade.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Modalidade getTipo() {
		return Modalidade.toEnum(modalidade);
	}

	public void setTipo(Modalidade modalidade) {
		this.modalidade = modalidade.getCod();
	}

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setEnderecos(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}