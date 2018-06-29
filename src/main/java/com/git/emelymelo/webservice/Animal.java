/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.git.emelymelo.webservice;

/**
 *
 * @author Emely Melo
 */
public class Animal {
    
    int id;
    private String tipoDeAnimal;
    private String nome;
    
    public Animal(String tipoDeAnimal, String nome){
        this.tipoDeAnimal = tipoDeAnimal;
        this.nome = nome;
    }
    public Animal (int id){ //por cauda do listar pelo id
        this.id = id;
    }
    public String getTipoDeAnimal(){
        return tipoDeAnimal;
    }
    public void setTipoDeAnimal(String tipoDeAnimal){
        this.tipoDeAnimal = tipoDeAnimal;
    }
    public String getAnimal(){
        return nome;
    }
    public void setAnimal(String nome){
        this.nome = nome;
    }
    
    
}
