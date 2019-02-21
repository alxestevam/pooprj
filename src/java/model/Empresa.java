/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author glauc
 */
public class Empresa {
    
    private int codigo;
    private String nome;
    
    private ArrayList<Funcionario> funcionarios = new ArrayList();

    public Empresa(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public void addFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }
   
    public void removeFuncionario(Funcionario funcionario){
        funcionarios.remove(funcionario);
    }
    
    
    
}
