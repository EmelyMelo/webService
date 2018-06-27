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
    
    static AnimalDAO animalDAO;
    
    @GET
    @Path("criar") 
    public Response create(@QueryParam("nome") String nome, 
                           @QueryParam("idade") int idade){
        Animal animal = new Animal(nome,idade);
        animalDAO.getInstance().criar(animal);
        return Response.status(Response.Status.OK).build();
    }
    
    @GET
    @Path("listar")
    @Produces(MediaType.TEXT_PLAIN)
    public Response listar(@QueryParam("id") String id){
        Animal animal = animalDAO.getInstance().listar(id);
        Gson gson = new Gson();
        return Response.status(Response.Status.OK).entity(gson.toJson(animal)).build();
    }
    
    @POST
    @Path("atualizar")
    public Response atualizar(@QueryParam("id") String id,
                           @QueryParam("nome") String nome, 
                           @QueryParam("idade") int idade){
        Animal game = new Animal(nome,idade);
        animalDAO.getInstance().atualizar(id, game);
        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("remover")
    public Response remover(@QueryParam("id") String id){
        animalDAO.getInstance().remover(id);
        return Response.status(Response.Status.OK).build();
    }

    
}
