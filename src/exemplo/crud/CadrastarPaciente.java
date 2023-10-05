
package exemplo.crud;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import modelo.GeneroPaciente;
import modelo.Paciente;
import utilitario.JpaUtil;
import modelo.Endereco;
import utilitario.DateUtil;
/**
 *
 * @author Cliente
 */
public class CadrastarPaciente {
    public static void Paciente() throws ParseException {
        
        List<Paciente> pacientes = new ArrayList<>();
        
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        Paciente paciente = new Paciente();
        paciente.setNome(JOptionPane.showInputDialog("Nome do Paciente:"));
        paciente.setDataDeNascimento(DateUtil.StringToDate(JOptionPane.showInputDialog("Informe a data de Nascimento do Paciente!\n   Formato(dia/Mês/Ano)")));
        int genero = Integer.parseInt(JOptionPane.showInputDialog("1. Masculino   2. Feminino"));
        switch (genero) {
            case 1:
                paciente.setGenero(GeneroPaciente.MASCULINO);
                break;
            case 2:
                paciente.setGenero(GeneroPaciente.FEMININO);
                break;
            default:
                JOptionPane.showConfirmDialog(null, "Gênero Inválido");
                break;
        }
        paciente.setTelefone(JOptionPane.showInputDialog("Número do Paciente"));
        paciente.setEmail(JOptionPane.showInputDialog("Email do Paciente"));
           
        
        Endereco e = new Endereco();
        e.setRua(JOptionPane.showInputDialog("Rua do Paciente"));
        e.setNumero(JOptionPane.showInputDialog("Número da casa do Paciente"));
        e.setBairro(JOptionPane.showInputDialog("Bairro do Paciente"));
        e.setCidade(JOptionPane.showInputDialog("Cidade do Paciente"));
        e.setEstado(JOptionPane.showInputDialog("Estado do Paciente"));
        e.setCep(JOptionPane.showInputDialog("CEP do Paciente"));
        paciente.setEndereco(e);
        
        pacientes.add(paciente);
        for(Paciente p : pacientes){
        em.persist(p);
        }
     
        em.getTransaction().commit();
        
    }
    
}