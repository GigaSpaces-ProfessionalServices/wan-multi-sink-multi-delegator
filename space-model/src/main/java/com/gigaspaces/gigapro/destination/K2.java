package com.gigaspaces.gigapro.destination;
import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "K2", schema = "DBO")
@SpaceClass
public class K2 {
    private String id;
    private J2 a;
    private String b;
    private Integer c;
    private String d;
    private Date e;
    private String f;
    private Integer g;
    private Integer h;
    private String i;
    private Date j;
    private String k;
    
    @Id
    @SpaceId
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public J2 getA() {
        return a;
    }
    public void setA(J2 a) {
        this.a = a;
    }
    public String getB() {
        return b;
    }
    public void setB(String b) {
        this.b = b;
    }
    public Integer getC() {
        return c;
    }
    public void setC(Integer c) {
        this.c = c;
    }
    public String getD() {
        return d;
    }
    public void setD(String d) {
        this.d = d;
    }
    public Date getE() {
        return e;
    }
    public void setE(Date e) {
        this.e = e;
    }
    public String getF() {
        return f;
    }
    public void setF(String f) {
        this.f = f;
    }
    public Integer getG() {
        return g;
    }
    public void setG(Integer g) {
        this.g = g;
    }
    public Integer getH() {
        return h;
    }
    public void setH(Integer h) {
        this.h = h;
    }
    public String getI() {
        return i;
    }
    public void setI(String i) {
        this.i = i;
    }
    public Date getJ() {
        return j;
    }
    public void setJ(Date j) {
        this.j = j;
    }
    public String getK() {
        return k;
    }
    public void setK(String k) {
        this.k = k;
    }
}