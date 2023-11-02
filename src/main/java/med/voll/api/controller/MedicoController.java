package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Especialidade;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

  @Autowired
  MedicoRepository repository;

  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {

    // repository.save(new Medico(null, dados.nome(), dados.email(),
    // dados.crm(), new Endereco(dados.endereco().logradouro(),
    // dados.endereco().bairro(),
    // dados.endereco().cep(),
    // dados.endereco().complemento(),
    // dados.endereco().uf(), dados.endereco().cidade()), dados.especiliadade()));

    repository.save(new Medico(dados));

  }
}
