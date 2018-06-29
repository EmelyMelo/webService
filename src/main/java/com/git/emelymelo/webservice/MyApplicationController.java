/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.git.emelymelo.webservice;
//está dando erro no Gson
import com.google.gson.Gson;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Emely Melo   
 */
@Path("meuwebservice")
public class MyApplicationController {
        
    @GET
    @Path("salvar") 
    public Response create(@QueryParam("tipoDeAnimal") String tipoDeAnimal, 
                           @QueryParam("nome") String nome){
        Animal animal = new Animal(tipoDeAnimal,nome);
        AnimalDAO.getInstance().salvar(animal);
        Gson gson = new Gson();
        return Response.status(Response.Status.OK).entity(gson.toJson(animal)).build();
    }
   
    
    @GET
    @Path("listar")
    @Produces(MediaType.TEXT_PLAIN)
    public String listar(){
        Gson gson = new Gson();
        return gson.toJson(AnimalDAO.getInstance().listar());
    }
    
       
    @GET
    @Path("atualizar")
    public Response atualizar(@QueryParam("id") String id,
                           @QueryParam("tipodeanimal") String tipoDeAnimal, 
                           @QueryParam("nome") String nome){
        Animal animal = new Animal(tipoDeAnimal,nome);
        AnimalDAO.getInstance().atualizar(id, animal);
        Gson gson = new Gson();
        return Response.status(Response.Status.OK).entity(gson.toJson(animal)).build();    
    }
    
    @GET
    @Path("remover")
    public Response remover(@QueryParam("id") int id){
        AnimalDAO.getInstance().remover(id);
        return Response.status(Response.Status.OK).build();
    }

    
}
