package edu.pong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;

@Entity
@Table(name="t_users")
public class User extends PanacheEntityBase{
    
    public User() {
    }
    
    public User(String name, int prop) {
        this.name = name;
        this.prop = prop;
    }


    @Id
    @NotNull
    @Column(name="user_nom")
    public String name;

    @Column(name="user_prop")
    public int prop;

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

}
