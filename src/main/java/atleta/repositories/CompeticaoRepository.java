package atleta.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import atleta.domain.Competicao;


@Repository
public interface CompeticaoRepository extends JpaRepository<Competicao, Integer>{
	

}