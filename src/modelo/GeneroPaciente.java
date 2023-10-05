/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

/**
 *
 * @author Cliente
 */
public enum GeneroPaciente {
    FEMININO("Feminino"),
    MASCULINO("Masculino");
    
    private final String descricao;
    
    GeneroPaciente(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
}
