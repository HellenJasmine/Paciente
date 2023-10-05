/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.crud;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import modelo.Paciente;
import modelo.Prescricao;
import utilitario.DateUtil;
import utilitario.JpaUtil;

/**
 *
 * @author Cliente
 */
public class CadrastarPrescricao {
    public static void prescricao() throws ParseException {
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        ListarPacientes.todos();
        Long id = Long.valueOf(JOptionPane.showInputDialog("Digite o ID do Paciente para atualizar"));

        Paciente p = em.find(Paciente.class, id);
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
        if(opc == 2){
        continuar = false;
        }
        }
        p.getConsulta().setPrescricoes(prescricoes);

        
    }
}
