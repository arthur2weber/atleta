package atleta.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atleta.domain.enums.Modalidade;
import atleta.domain.Competicao;
import atleta.domain.Atleta;
import atleta.domain.Inscricao;
import atleta.domain.enums.Modalidade;
import atleta.repositories.CompeticaoRepository;
import atleta.repositories.AtletaRepository;
import atleta.repositories.InscricaoRepository;

@Service
public class DbService {

	@Autowired
	private CompeticaoRepository comRep;
	
	@Autowired
	private AtletaRepository atlRep;
	
	@Autowired
	private InscricaoRepository insRep;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		
		Competicao c1 = new Competicao(null, "Corida em Lagua", "13/04/2019");
		Competicao c2 = new Competicao(null, "Corrida em Tubarao", "20/04/2019");
		Competicao c3 = new Competicao(null, "Corrida em Capivari", "22/04/2019");
		Competicao c4 = new Competicao(null, "Corrida em Jaguaruna", "28/04/2019");
		
		
		Atleta atl1 = new Atleta(null, "Arthur",  Modalidade.BARREIRA100M);
		
		Inscricao ins1 = new Inscricao(null, atl1, c2);
		Inscricao ins2 = new Inscricao(null, atl1, c3);
		atl1.getInscricoes().addAll(Arrays.asList(ins1, ins2));
		
		comRep.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		atlRep.saveAll(Arrays.asList(atl1));
		insRep.saveAll(Arrays.asList(ins1, ins2));
		
	}

}