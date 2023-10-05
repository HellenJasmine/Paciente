/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.crud;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
public class Cadrastar{
    public static void Consulta() throws ParseException {
        EntityManager em = JpaUtil.conexao();
        
        em.getTransaction().begin();
        ListarPacientes.todos();
        Long id = Long.valueOf(JOptionPane.showInputDialog("Digite o ID do Paciente para atualizar"));

        Paciente p = em.find(Paciente.class, id);
        Consulta consulta = new Consulta();
        consulta.setDataConsulta(DateUtil.StringToDate(JOptionPane.showInputDialog("Data da Consulta:")));
        consulta.setDescricao(JOptionPane.showInputDialog("Descrições da Consulta:"));
        consulta.setResultados(JOptionPane.showInputDialog("Resultados da Consulta:"));
        
        
        boolean continuar = true;
        List<Prescricao> prescricoes = new ArrayList<>();
        while(continuar){
        Prescricao a = new Prescricao();
        a.setDataDaPrescricao(DateUtil.StringToDate(JOptionPane.showInputDialog("Data da Prescrição")));
        a.setMedicamento(JOptionPane.showInputDialog("Medicamento:"));
        a.setDosagem(JOptionPane.showInputDialog("Dosagem do Medicamento:"));
        a.setInstrucoesDeUso(JOptionPane.showInputDialog("Instruções da Medicação:"));
        prescricoes.add(a);
        int opc = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar? 1. sim   2. nao"));
        if(opc == 2){break;}
        }
        consulta.setPrescricoes(prescricoes);
        p.setConsulta(consulta);
    
        
        em.merge(p);
        em.getTransaction().commit();
        
        
    }
   
}

