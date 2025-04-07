package med.voll.api.paciente;


import jakarta.persistence.*;
import lombok.Data;
import med.voll.api.endereco.Endereco;

@Entity(name="Paciente")
@Table(name="pacientes")
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome, email, telefone, cpf;

    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());

    }

    public Paciente() {

    }
}
