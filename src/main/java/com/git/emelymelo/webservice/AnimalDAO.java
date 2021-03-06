/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.git.emelymelo.webservice;

import java.util.ArrayList;
/**
 *
 * @author Emely Melo
 */
public class AnimalDAO {
     private static AnimalDAO instance;
     static private ArrayList<Animal> animais;
     static int id;
     
     private AnimalDAO(){
         id = 1;
         this.animais = new ArrayList<Animal>();
         Animal a1 =  new Animal("cachorro", "bolinha");
         salvar(a1);
         Animal a2 =  new Animal("gato", "pelinho");
         salvar(a2);
     }
    //só pode instanciar uma vez
    public static AnimalDAO getInstance(){
        if(instance==null){
            instance=new AnimalDAO();
        }
        return instance;
    }
    
    //salva o animal no array mudando seu id
    public boolean salvar(Animal a){
        a.id = id;
        id++;
        return this.animais.add(a);
    }
    
    public ArrayList<Animal> listarTodos(){
        return this.animais;
    }
       
    public Animal listarPorId(Animal a){
        for(int i=0; i<this.animais.size(); i++){
            if(this.animais.get(i).id == a.id){
                a = this.animais.get(i);
                return this.animais.get(i);
            }
        }
        return a;
    }
    
    public Animal atualizar(Animal a){
        int index = pegarIndex(a);
        animais.set(index,a);
        return listarPorId(a);
        
        
    }
    
    public boolean remover(Animal a){
        int index = pegarIndex(a);
        this.animais.remove(index);
        return true;
    }
        public int pegarIndex(Animal a){
    int index = -1;
    for(int i=0;i<animais.size();i++){
        if(animais.get(i).id == a.id){
            index = i;
        }
    }
    return index;
    
    }
}
