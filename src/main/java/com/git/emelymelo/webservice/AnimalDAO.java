/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.git.emelymelo.webservice;

import java.util.HashMap; //mapeamento de objeto no modelo chave/valor
import java.util.Map;

/**
 *
 * @author Emely Melo
 */
public class AnimalDAO {
     private static AnimalDAO instance;
    private final Map<String,Animal> animais = new HashMap<>();
    
    public static AnimalDAO getInstance(){
        if(instance==null){
            instance=new AnimalDAO();
        }
        return instance;
    }
    
    public boolean criar(Animal a){
        if(animais.isEmpty()){
            this.animais.put("0", a);
        }else{
         int count = this.animais.size();
         this.animais.put(Integer.toString(count),a);
        }
        return true;
    }
    
    public Animal listar(String id){
        return this.animais.get(id);
    }
    
    public boolean atualizar(String id, Animal a){
        this.animais.put(id,a);
        return true;
    }
    
    public boolean remover(String id){
        this.animais.remove(id);
        return true;
    }
}
