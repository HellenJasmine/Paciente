/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.crud;

import java.util.List;
import javax.persistence.*;
import javax.swing.JOptionPane;
import modelo.Consulta;
import modelo.Paciente;
import modelo.Prescricao;
import utilitario.DateUtil;
import utilitario.JpaUtil;

/**
 *
 * @author Cliente
 */
public class VerConsulta {
    public static void Paciente() {
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        ListarPacientes.todos();
        Long id = Long.valueOf(JOptionPane.showInputDialog("Digite o ID do Paciente para Visualizar"));
        Paciente p = em.find(Paciente.class, id);
        if(p!= null){
            Consulta c = p.getConsulta();
        JOptionPane.showConfirmDialog(null, "Paciente:"+ p.getNome()+"\nDescrição:"+ p.getConsulta().getDescricao()+ "\nData: "+DateUtil.format(DateUtil.DD_MM_YYYY,  p.getConsulta().getDataConsulta())+"\nResultados :" + p.getConsulta().getResultados());
        StringBuilder sb = new StringBuilder("Lista de Prescrições:\n");
        List<Prescricao> prescricoes = c.getPrescricoes();
        for (Prescricao prescricao : prescricoes){
            sb.append( "Prescrições:\n Medicamento ").append(prescricao.getMedicamento()).append(", Data da Prescrição :").append(DateUtil.format(DateUtil.DD_MM_YYYY, prescricao.getDataDaPrescricao())).append("Dosagem:").append(prescricao.getDosagem()).append("Instruções de Uso:").append(prescricao.getInstrucoesDeUso());
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        
        
     
    
}}}
