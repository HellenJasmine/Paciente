/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.crud;

import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import modelo.Consulta;
import modelo.Paciente;
import utilitario.DateUtil;
import utilitario.JpaUtil;

/**
 *
 * @author Cliente
 */
public class AtualizarConsulta {
    public static void a() throws ParseException {
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        ListarPacientes.todos();
        
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Paciente para atualizar"));
        Paciente p = em.find(Paciente.class, id);
        Consulta c = new Consulta();
        if(p != null){
          
            c.setDataConsulta(DateUtil.StringToDate(JOptionPane.showInputDialog("Data Atualizada:")));
            c.setDescricao(JOptionPane.showInputDialog("Descrição atualizada:"));
            c.setResultados(JOptionPane.showInputDialog("Resultados Atualizados"));
            p.setConsulta(c);
       
        JOptionPane.showConfirmDialog(null,"Consulta atualizado!!!");
        }else{
        JOptionPane.showConfirmDialog(null, "Paciente não encontrado!!!");
        }
        em.merge(p);
        
        em.getTransaction().commit();
        
        
  
    }
        

}