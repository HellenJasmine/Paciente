/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.crud;

import java.text.ParseException;
import java.util.ArrayList;
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
public class AtualizarPrescricoes {
    public static void todas() throws ParseException{
    EntityManager em = JpaUtil.conexao();
    em.getTransaction().begin();
    ListarPacientes.todos();
    Long id = Long.valueOf(JOptionPane.showInputDialog("Digite o ID do Paciente para atualizar"));

    Paciente p = em.find(Paciente.class, id);
    if(p!= null){
        Consulta consulta = p.getConsulta();
        if(consulta != null){
            List<Prescricao> prescricoes = new ArrayList<>();
        boolean continuar = true;
        while(continuar){
        Prescricao a = new Prescricao();
        JOptionPane.showConfirmDialog(null,"Atualizar Medicamento(s)");
        a.setDataDaPrescricao(DateUtil.StringToDate(JOptionPane.showInputDialog("Nova data:")));
        a.setMedicamento(JOptionPane.showInputDialog("Novo Medicamento:"));
        a.setDosagem(JOptionPane.showInputDialog(" Nova dosagem:"));
        a.setInstrucoesDeUso(JOptionPane.showInputDialog("Instruções da Medicação:"));
        prescricoes.add(a);
        int opc = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar? 1. sim   2. nao"));
        if(opc == 2){
            consulta.setPrescricoes(prescricoes);
            em.merge(consulta);
           
            em.getTransaction().commit();
            break;
        }
        }
        
        
   
        }}}}
