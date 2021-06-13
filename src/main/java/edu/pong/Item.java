package edu.pong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;


@Entity
@Table(name="t_items")
public class Item extends PanacheEntityBase{
    
    public Item() {
    }

    public Item(String name, int prop, String tipo) {
        this.name = name;
        this.prop = prop;
        this.tipo = tipo;
    }

    @Id
    @NotNull
    @Column(name="item_nom")
    public String name;

    @Column(name="item_prop")
    public int prop;
    
    @Column(name="item_tipo")
    public String tipo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProp() {
        return prop;
    }

    public void setProp(int prop) {
        this.prop = prop;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
