/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.git.emelymelo.webservice;
//está dando erro no Gson
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
        
    //localhost:8080/WebService/meuwebservice/salvar?tipoDeAnimal=cachorro&nome=doguinho
    @POST
    @Path("salvar") 
    public Response create(@QueryParam("tipoDeAnimal") String tipoDeAnimal, 
                           @QueryParam("nome") String nome){
        Animal animal = new Animal(tipoDeAnimal,nome);
        AnimalDAO.getInstance().salvar(animal);
        Gson gson = new Gson();
        return Response.status(Response.Status.OK).entity(gson.toJson(animal)).build();
    }
   
    //localhost:8080/WebService/meuwebservice/listar
    @GET
    @Path("listar")
    @Produces(MediaType.TEXT_PLAIN)
    public String listarTodos(){
        Gson gson = new Gson();
        return gson.toJson(AnimalDAO.getInstance().listarTodos());
    }
    //localhost:8080/WebService/meuwebservice/listarporid?id=2
    @GET
    @Path("listarporid")
    @Produces(MediaType.TEXT_PLAIN)
    public String listarPorId(@QueryParam("id") int id){
        Animal animal = new Animal(id);
        Animal a = AnimalDAO.getInstance().listarPorId(animal);
        Gson gson = new Gson();
        return gson.toJson(a);
    }
     //localhost:8080/WebService/meuwebservice/atualizar?id=2&tipodeanimal=cat&nome=gatinha  
    @PUT
    @Path("atualizar")
    public Response atualizar(@QueryParam("id") int id,
                           @QueryParam("tipodeanimal") String tipoDeAnimal, 
                           @QueryParam("nome") String nome){
        Animal a = new Animal(id, tipoDeAnimal, nome);
        a = AnimalDAO.getInstance().atualizar(a);
        Gson gson = new Gson();
        return Response.status(Response.Status.OK).entity(gson.toJson(a)).build();    
    }
    //localhost:8080/WebService/meuwebservice/remover?id=1
    @DELETE
    @Path("remover")
    public String remover(@QueryParam("id") int id){
        Animal animal = new Animal(id);
        AnimalDAO.getInstance().remover(animal);
        return listarTodos();
    }

    
}
