package med.voll.api.paciente;

import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome,

    String sobrenome,

    Integer idade,

    String email,

    String cpf,

    String telefone,

    DadosEndereco endereco,

    String motivoConsulta) {

}
