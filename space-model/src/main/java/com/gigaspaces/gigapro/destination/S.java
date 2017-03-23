package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "S", schema = "DBO")
public class S {
    private String id;
    private T a;
    private String b;
    private String c;
    private Date d;
    private Date e;
    private String f;
    private Date g;
    private Date h;
    private String i;
    private String j;
    private U k;
    private U l;
    private List<V> m;
    private Map<B, R> n;
    private Map<B, R> o;
    
    @SpaceId(autoGenerate = false)
    @Id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public T getA() {
        return a;
    }
    public void setA(T a) {
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
    public Date getD() {
        return d;
    }
    public void setD(Date d) {
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
    public String getI() {
        return i;
    }
    public void setI(String i) {
        this.i = i;
    }
    public String getJ() {
        return j;
    }
    public void setJ(String j) {
        this.j = j;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public U getK() {
        return k;
    }
    public void setK(U k) {
        this.k = k;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public U getL() {
        return l;
    }
    public void setL(U l) {
        this.l = l;
    }
    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public List<V> getM() {
        return m;
    }
    public void setM(List<V> m) {
        this.m = m;
    }
    @Transient
    public Map<B, R> getN() {
        return n;
    }
    public void setN(Map<B, R> n) {
        this.n = n;
    }
    @Transient
    public Map<B, R> getO() {
        return o;
    }
    public void setO(Map<B, R> o) {
        this.o = o;
    }
}