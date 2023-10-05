/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao;

import exemplo.crud.*;
import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import utilitario.JpaUtil;

/**
 *
 * @author Cliente
 */
public class Menu {
    public static void main(String[] args) throws ParseException {
        boolean continuar = true;
        EntityManager em = JpaUtil.conexao();
        while(continuar){
            int opc = Integer.parseInt(JOptionPane.showInputDialog("--------------------MENU PACIENTE--------------------\n1.Cadrastar Paciente\n2.Visualizar Pacientes\n3.Atualizar Paciente\n4.Cadrastar Consulta\n5.Atualizar Consulta\n6. Ver Consulta \n7.Cadrastar Prescrição\n8.Atualizar Prescrição  \n 9. Excluir Paciente\n 0. Sair"));
            if(opc == 1){
            CadrastarPaciente.Paciente();}
            if(opc ==2){
            int opc2= Integer.parseInt(JOptionPane.showInputDialog("Deseja ver:\n 1.Todos\n 2.Pacientes Mulheres\n 3.Pacientes Homens\n 4. Paciente Específico"));
                if(opc2 == 1){ListarPacientes.todos();}
                if(opc2 == 2){ListarPacientes.femininas();}
                if(opc2 == 3){ListarPacientes.Masculinos();}
                if(opc2 == 4){ListarPacientes.Individual();}
                else{JOptionPane.showConfirmDialog(null, "Opção Inválida");}
            }if(opc==3){
            int opc3 = Integer.parseInt(JOptionPane.showInputDialog("Deseja Atualizar:\n 1. Telefone\n 2.Email\n 3.Endereço"));
                if(opc3 == 1){AtualizarPaciente.Telefone();}
                if(opc3 == 2){AtualizarPaciente.Email();}
                if(opc3 == 3){AtualizarPaciente.Endereco();}
                else{JOptionPane.showConfirmDialog(null, "Opção Inválida");}
            }if(opc == 4){
                Cadrastar.Consulta();
            }if(opc == 5){
                AtualizarConsulta.a();
            }if(opc == 6){
                VerConsulta.Paciente();
            }if(opc == 7){
               CadrastarPrescricao.prescricao();
               
            }if(opc == 8){
                AtualizarPrescricoes.todas();
            }
            if(opc == 9){
                ExcluirPaciente.P();
            }if(opc == 0){break;}
            }
        JpaUtil.fecharConexao();
        
        
        }}
    

