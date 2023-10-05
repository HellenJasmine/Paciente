
package modelo;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author Cliente
 */
@Entity
@Table(name = "tab_paciente")
public class Paciente implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente",initialValue = 1)
    @GeneratedValue(generator = "seq_paciente", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 200, nullable = true)
    private String nome;
    @Column(nullable = true)
    private Date dataDeNascimento;
    @Enumerated(EnumType.STRING)
    private GeneroPaciente genero;
    @Column(nullable = true)
    private String telefone;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @Column(nullable = true)
    private String email;
    @OneToOne
    private Consulta consulta;


    public Paciente(String nome, Date dataDeNascimento, GeneroPaciente genero, String telefone, Endereco endereco, String email, Consulta consulta) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.consulta = consulta;
    }
    

    public Paciente() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GeneroPaciente getGenero() {
        return genero;
    }

    public void setGenero(GeneroPaciente genero) {
        this.genero = genero;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nome=" + nome + ", dataDeNascimento=" + dataDeNascimento + ", endereço=" + endereco + ", telefone=" + telefone + ", email=" + email + '}';
    }

   
    
}
    
    


