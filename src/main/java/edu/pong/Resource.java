package edu.pong;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/torneos")
public class Resource {
    
    @Inject
    Service service;

    @GET
    public Set<Item> list(){
        return service.list();
    }

    @GET
    @Path("/user")
    public Set<User> listUser(){
        return service.listUser();
    }

    @GET
    @Path("/orden")
    public Set<Orden> listOrden(){
        return service.listOrden();
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Orden addOrden(Orden orden){
        return service.postOrder(orden);
    }

    

    @POST
    @Path("/addmultiple")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void addOrden(Set<Orden> ordenes){
        service.addmultipleOrders(ordenes);
    }


    @GET
    @Path("/usertorneo")
    public List<Orden> listaUsuario(User user){
        return service.listarOrdenesUser(user);
    }

    @GET
    @Path("/usertorneo/{name}")
    public List<Orden> listaUsuario(@PathParam("name") String name){
        return service.listaporparametros(name);
    }

    // POST
    // @Path("/user/add")
    // @Consumes(MediaType.APPLICATION_JSON)
    // @Produces(MediaType.APPLICATION_JSON)
    // @Transactional
    // public Orden addOrden(Orden orden){
    //     return service.postOrder(orden);
    // }
}
