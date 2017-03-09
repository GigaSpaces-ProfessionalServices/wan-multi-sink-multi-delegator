package com.gigaspaces.gigapro.destination;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "X", schema = "DBO")
public class X {
    private String id;
    private String a;
    private T b;
    private B c;
    private String d;
    private String e;
    private Date f;
    private Date g;
    private Date h;
    
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
    @ManyToOne(cascade = {CascadeType.MERGE})
    public T getB() {
        return b;
    }
    public void setB(T b) {
        this.b = b;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public B getC() {
        return c;
    }
    public void setC(B c) {
        this.c = c;
    }
    public String getD() {
        return d;
    }
    public void setD(String d) {
        this.d = d;
    }
    public String getE() {
        return e;
    }
    public void setE(String e) {
        this.e = e;
    }
    public Date getF() {
        return f;
    }
    public void setF(Date f) {
        this.f = f;
    }
    public Date getG() {
        return g;
    }
    public void setG(Date g) {
        this.g = g;
    }
    public Date getH() {
        return h;
    }
    public void setH(Date h) {
        this.h = h;
    }
}
