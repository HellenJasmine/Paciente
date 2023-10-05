/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.crud;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import modelo.Consulta;
import modelo.Paciente;
import utilitario.JpaUtil;

/**
 *
 * @author Cliente
 */
public class ExcluirPaciente {
    public static void P() {
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        ListarPacientes.todos();
        
        Long id = Long.valueOf(JOptionPane.showInputDialog("Digite o ID do Paciente para excluir:"));
        
        Paciente p = em.find(Paciente.class, id );
        Consulta consulta = p.getConsulta();
        if(consulta!= null){
            consulta.getPrescricoes().clear();
            em.remove(p);
        }else{
        JOptionPane.showConfirmDialog(null, "Paciente não Encontrado!!!");
        }
        
        
        em.getTransaction().commit();
       
    }
}
