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

  @GetMapping("/")
  public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
    return repository.findAll(paginacao).map(DadosListagemMedico::new);

    // na url da requisição podemos passar parametros para melhorar ainda mais a
    // paginação:
    // size=x (numero de registros que vem da consulta, padrao e 20)
    // page=y (numero da pagina que contem os registros)
    // sort=(atributo da entidade) >> Faz a ordenção apartir do atributo padrao do
    // menor para o maior
    // se quisermos inverter basta colocar depois do atributo ,desc
    // Exemplo
    // http://localhost:8080/medicos/?size=3&page=3
    // http://localhost:8080/medicos/?sort=nome
    // http://localhost:8080/medicos/?sort=nome,desc
    // http://localhost:8080/medicos/?size=2&sort=nome,desc&page=0
  }
}
