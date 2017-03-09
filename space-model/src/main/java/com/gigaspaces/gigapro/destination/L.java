package com.gigaspaces.gigapro.destination;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.List;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "L", schema = "DBO")
public class L {
    private String id;
    private String a;
    private String b;
    private String c;
    private List<M> d;
    
    @Id
    @SpaceId(autoGenerate = false)
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
    public String getB() {
        return b;
    }
    public void setB(String b) {
        this.b = b;
    }
    public String getC() {
        return c;
    }
    public void setC(String c) {
        this.c = c;
    }
    @OneToMany(cascade = {CascadeType.MERGE})
    public List<M> getD() {
        return d;
    }
    public void setD(List<M> d) {
        this.d = d;
    }
}
