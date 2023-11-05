package med.voll.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.controller.DadosListagemMedico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

  Page<Medico> findByAtivoTrue(Pageable paginacao);

}
