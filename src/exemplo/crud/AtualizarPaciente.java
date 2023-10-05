
package exemplo.crud;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import modelo.Endereco;
import modelo.Paciente;
import utilitario.JpaUtil;


/**
 *
 * @author Cliente
 */
public class AtualizarPaciente{
    public static void Telefone() {
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        ListarPacientes.todos();
        
        Long id = Long.valueOf(JOptionPane.showInputDialog("Digite o ID do Paciente para atualizar"));
        Paciente p = em.find(Paciente.class, id);
        if(p != null){
        p.setTelefone(JOptionPane.showInputDialog("Digite o novo NÚMERO para atualizar"));
        JOptionPane.showConfirmDialog(null,"Telefone atualizado!!!");
        }else{
        JOptionPane.showConfirmDialog(null, "Paciente não encontrado!!!");
        }
        em.merge(p);
        
        em.getTransaction().commit();
        
    }
        public static void Email() {
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        ListarPacientes.todos();
        
        Long id = Long.valueOf(JOptionPane.showInputDialog("Digite o ID do Paciente para atualizar"));
        Paciente p = em.find(Paciente.class, id);
        if(p != null){
        p.setEmail(JOptionPane.showInputDialog("Digite o novo EMAIL para atualizar!"));
        JOptionPane.showConfirmDialog(null,"Email atualizado!!!");
        }else{
        JOptionPane.showConfirmDialog(null, "Paciente não encontrado!!!");
        }
        em.merge(p);
        
        em.getTransaction().commit();
    }
        public static void Endereco() {
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        ListarPacientes.todos();
        
        Long id = Long.valueOf(JOptionPane.showInputDialog("Digite o ID do Paciente para atualizar"));
        Paciente p = em.find(Paciente.class, id);
        if(p != null){
        Endereco e = new Endereco();
        JOptionPane.showConfirmDialog(null, "Atualize seu Endereço:");
        e.setRua(JOptionPane.showInputDialog("Rua:"));
        e.setNumero(JOptionPane.showInputDialog("Número da Casa"));
        e.setBairro(JOptionPane.showInputDialog("Bairro:"));
        e.setCidade(JOptionPane.showInputDialog("Cidade:"));
        e.setEstado(JOptionPane.showInputDialog("Estado:"));
        e.setCep(JOptionPane.showInputDialog("CEP:"));
        p.setEndereco(e);
        JOptionPane.showConfirmDialog(null,"Endereço atualizado!!!");
        }else{
        JOptionPane.showConfirmDialog(null, "Paciente não encontrado!!!");
        }
        em.merge(p);
        
        em.getTransaction().commit();

    }
}
