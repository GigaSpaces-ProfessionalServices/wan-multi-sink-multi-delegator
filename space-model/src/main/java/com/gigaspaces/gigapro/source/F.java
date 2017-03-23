package com.gigaspaces.gigapro.source;

import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.List;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "F", schema = "DBO")
public class F {
    private String id;

    private String a;
    private List<E> b;
    
    @SpaceId(autoGenerate = false)
    @Id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }
    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public List<E> getB() {
        return b;
    }
    public void setB(List<E> b) {
        this.b = b;
    }
}