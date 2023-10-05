/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.crud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import modelo.GeneroPaciente;
import modelo.Paciente;
import utilitario.JpaUtil;

/**
 *
 * @author Cliente
 */
public class ListarPacientes {
    public static void todos() {
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        
        List<Paciente> pacientes = em.createQuery("select a from Paciente a").getResultList();
        
        StringBuilder sb = new StringBuilder("Lista de Pacientes:\n");
        for (Paciente p : pacientes) {
            sb.append("ID: ").append(p.getId()).append(", Nome: ").append(p.getNome()).append(", Gênero: ").append(p.getGenero()).append(", Telefone:").append(p.getTelefone()).append(", Email:").append(p.getEmail()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        
        em.getTransaction().commit();
        
    }
    public static void femininas() {
    EntityManager em = JpaUtil.conexao();
    TypedQuery<Paciente> query = em.createQuery("SELECT p FROM Paciente p WHERE p.genero = :genero", Paciente.class);
    query.setParameter("genero", GeneroPaciente.FEMININO);
    List<Paciente> pacientesFemininas = query.getResultList();
    StringBuilder sb = new StringBuilder("Lista de Pacientes Mulheres:\n");
    for (Paciente p : pacientesFemininas) {
        sb.append("ID: ").append(p.getId()).append(", Nome: ").append(p.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    public static void Masculinos() {
    EntityManager em = JpaUtil.conexao();
    TypedQuery<Paciente> query = em.createQuery("SELECT p FROM Paciente p WHERE p.genero = :genero", Paciente.class);
    query.setParameter("genero", GeneroPaciente.MASCULINO);
    List<Paciente> pacientesMasculicos = query.getResultList();
    StringBuilder sb = new StringBuilder("Lista de Pacientes Homens:\n");
    for (Paciente p : pacientesMasculicos) {
        sb.append("ID: ").append(p.getId()).append(", Nome: ").append(p.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    
    public static void Individual(){
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        ListarPacientes.todos();
        
        Long id = Long.valueOf(JOptionPane.showInputDialog("Digite o ID do Paciente para atualizar"));
        Paciente p = em.find(Paciente.class, id);
        if(p != null){
        JOptionPane.showConfirmDialog(null,"Nome:"+ p.getNome()+"Data de Nascimento:"+p.getDataDeNascimento()+"Gênero:"+p.getGenero()+"Número de Telefone:"+p.getTelefone()+ "Email:"+p.getEmail()+"Endereço:"+p.getEndereco());
        }else{
        JOptionPane.showConfirmDialog(null, "Paciente não encontrado!!!");
        }
       
        
        em.getTransaction().commit();
      

}}