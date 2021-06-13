package edu.pong;

import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="t_ordenes")
public class Orden extends PanacheEntityBase{
    
    public Orden() {
    }
    
    public Orden(Long id,User user, Item item) {
        this.id = id;
        this.user = user;
        this.item = item;
    }

    @Id
    public Long id;
    
    @OneToOne
    @JoinColumn(name="ord_user")
    public User user;

    @OneToOne
    @JoinColumn(name="ord_item")
    public Item item;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
