package com.gigaspaces.gigapro.destination;
import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.List;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "F3", schema = "DBO")
public class F3 {

    private String id;
    private X2 a;
    private List<A3> b;
    private Long c;
    private Long d;
    private Long e;
    private String f;
    
    @SpaceId(autoGenerate = false)
    @Id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public X2 getA() {
        return a;
    }
    public void setA(X2 a) {
        this.a = a;
    }
    @OneToMany(cascade = {CascadeType.MERGE})
    public List<A3> getB() {
        return b;
    }
    public void setB(List<A3> b) {
        this.b = b;
    }
    public Long getC() {
        return c;
    }
    public void setC(Long c) {
        this.c = c;
    }
    public Long getD() {
        return d;
    }
    public void setD(Long d) {
        this.d = d;
    }
    public Long getE() {
        return e;
    }
    public void setE(Long e) {
        this.e = e;
    }
    public String getF() {
        return f;
    }
    public void setF(String f) {
        this.f = f;
    }
}