package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.medico.Medico;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

  @Autowired
  PacienteRepository pacienteRepository;

  @PostMapping("/")
  @Transactional
  public void cadastrarPaciente(@RequestBody DadosCadastroPaciente dados) {
    pacienteRepository.save(new Paciente(dados));
  }

  // @GetMapping("/")
  // public List<Paciente> listar() {
  // return pacienteRepository.findAll();
  // }
  @GetMapping("/")
  public Page<DadosListagemPaciente> listar(
      @PageableDefault(page = 0, size = 10, sort = { "nome" }) Pageable paginacao) {
    return pacienteRepository.findAll(paginacao).map(DadosListagemPaciente::new);
  }
}
