package edu.pong;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@ApplicationScoped
public class Service {

    public Set<Item> list(){
        Stream<Item> torneos = Item.streamAll();
        return torneos.collect(Collectors.toSet()); 
    }

   public Set<User> listUser(){
        Stream<User> user = User.streamAll();
        return user.collect(Collectors.toSet()); 
    }

    public Set<Orden> listOrden(){
        Stream<Orden> orden = Orden.streamAll();
        return orden.collect(Collectors.toSet()); 
    }

    public Orden postOrder(Orden orden){

        Optional<User> usuario = User.find("name", orden.user.getName()).firstResultOptional();
        Optional<Item> item = Item.find("name", orden.item.getName()).firstResultOptional();

        if(usuario.isPresent() && item.isPresent()){
            
            if(orden.user.prop >= orden.item.prop){
                orden.persist(); 
                return orden;
            }
        }
        return null;
  
    }

    public void addmultipleOrders(Set<Orden> listaorden){

        listaorden.forEach(e->postOrder(e));

    }

    public List<Orden> listarOrdenesUser(User user){

        return Orden.list("user", user);
  
    }

     public List<Orden> listaporparametros(String user){

        // Optional<User> usuario = User.find("name",user).firstResultOptional();
        // return Orden.list("user", usuario.get());


        List<Orden> listaordnees = Orden.listAll();

        return listaordnees.stream().filter(e->e.user.name.equals(user)).collect(Collectors.toList());
        

  
  
    }


}
