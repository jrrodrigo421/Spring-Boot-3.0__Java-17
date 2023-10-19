package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.medico.DadosCadastroMedico;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

  @PostMapping
  public void cadastrar(@RequestBody DadosCadastroMedico json) {

    System.out.println(json.nome());
    System.out.println(json.email());
    System.out.println(json.crm());
    System.out.println(json.especialidade());

    System.out.println("\n IMPRIMINDO json: \n\n " + json);
  }
}
