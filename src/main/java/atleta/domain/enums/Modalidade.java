package atleta.domain.enums;

public enum Modalidade {
	
	BARREIRA100M(1, "100m com barreira"),
	LIVRE100M(2, "100m livre");

	private int cod;
	private String descricao;

	private Modalidade(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao () {
		return descricao;
	}

	public static Modalidade toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (Modalidade x : Modalidade.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}