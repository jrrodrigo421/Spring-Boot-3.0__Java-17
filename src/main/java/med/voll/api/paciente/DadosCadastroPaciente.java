package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome,

        @NotBlank String sobrenome,

        @NotBlank Integer idade,

        @NotBlank @Email String email,

        @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") String cpf,

        @NotBlank String telefone,

        @NotBlank @Valid DadosEndereco endereco,

        @NotBlank String motivoConsulta) {

}
