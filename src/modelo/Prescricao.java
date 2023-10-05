package modelo;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;


/**
 *
 * @author Cliente
 */
@Entity
public class Prescricao implements Serializable {
   @Id
   @SequenceGenerator(name = "seq_prescriao", sequenceName = "seq_prescricao", initialValue = 1)
   @GeneratedValue(generator = "seq_prescricao", strategy = GenerationType.SEQUENCE)
   private Long id;
   private String Medicamento;
   private String dosagem;
   private String instrucoesDeUso;
   private Date dataDaPrescricao;
  
    public Prescricao() {
    }

    public Prescricao(Long id, String Medicamento, String dosagem, String instrucoesDeUso, Date dataDaPrescricao) {
        this.id = id;
        this.Medicamento = Medicamento;
        this.dosagem = dosagem;
        this.instrucoesDeUso = instrucoesDeUso;
        this.dataDaPrescricao = dataDaPrescricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicamento() {
        return Medicamento;
    }

    public void setMedicamento(String Medicamento) {
        this.Medicamento = Medicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getInstrucoesDeUso() {
        return instrucoesDeUso;
    }

    public void setInstrucoesDeUso(String instrucoesDeUso) {
        this.instrucoesDeUso = instrucoesDeUso;
    }

    public Date getDataDaPrescricao() {
        return dataDaPrescricao;
    }

    public void setDataDaPrescricao(Date dataDaPrescricao) {
        this.dataDaPrescricao = dataDaPrescricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.Medicamento);
        hash = 29 * hash + Objects.hashCode(this.dosagem);
        hash = 29 * hash + Objects.hashCode(this.instrucoesDeUso);
        hash = 29 * hash + Objects.hashCode(this.dataDaPrescricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prescricao other = (Prescricao) obj;
        if (!Objects.equals(this.Medicamento, other.Medicamento)) {
            return false;
        }
        if (!Objects.equals(this.dosagem, other.dosagem)) {
            return false;
        }
        if (!Objects.equals(this.instrucoesDeUso, other.instrucoesDeUso)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.dataDaPrescricao, other.dataDaPrescricao);
    }
   
   
}
