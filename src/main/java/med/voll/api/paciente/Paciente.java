package med.voll.api.paciente;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String sobrenome;
  private String telefone;
  private Integer idade;
  private String email;
  private String motivo_consulta;
  private String cpf;

  @Embedded
  private Endereco endereco;

  public Paciente(DadosCadastroPaciente dados) {
    this.nome = dados.nome();
    this.sobrenome = dados.sobrenome();
    this.idade = dados.idade();
    this.email = dados.email();
    this.telefone = dados.telefone();
    this.motivo_consulta = dados.motivoConsulta();
    this.endereco = new Endereco(dados.endereco());
    this.cpf = dados.cpf();
  }

}
