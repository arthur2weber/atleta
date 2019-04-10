package  atleta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import atleta.domain.Competicao;
import atleta.domain.Atleta;
import atleta.domain.Inscricao;
import atleta.domain.enums.Modalidade;
import atleta.dtos.AtletaDTO;
import atleta.dtos.AtletaNewDTO;
import atleta.repositories.AtletaRepository;
import atleta.repositories.InscricaoRepository;

@Service
public class  AtletaService {
	
	@Autowired
	private AtletaRepository repo;
	
	@Autowired
	private InscricaoRepository InscricaoRepository;

	public Atleta find(Integer id) {
		Optional<Atleta> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Atleta update(Atleta obj) {
		Atleta newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}

	public List<Atleta> findAll() {
		return repo.findAll();
	}
	
	public Atleta fromDTO(AtletaDTO objDto) {
		return new Atleta(objDto.getId(), objDto.getNome(), null);
	}
	
	public Atleta fromDTO(AtletaNewDTO objDto) {
		Atleta atl = new Atleta(null, objDto.getNome(), Modalidade.toEnum(objDto.getModalidade()));
		Competicao com = new Competicao(objDto.getCompeticaoId(), null, null);
		Inscricao ins = new Inscricao(null, atl, com);
		atl.getInscricoes().add(ins);
		return atl;
	}

	private void updateData(Atleta newObj, Atleta obj) {
		newObj.setNome(obj.getNome());
	}
	
	@Transactional
	public Atleta insert(Atleta obj) {
		obj.setId(null);
		obj = repo.save(obj);
		InscricaoRepository.saveAll(obj.getInscricoes());
		return obj;
	}

}