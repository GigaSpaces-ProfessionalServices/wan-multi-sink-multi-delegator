package com.gigaspaces.gigapro.destination;
import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Map;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "B3", schema = "DBO")
public class B3 {
    private String id;
    
    private B a;
    private Y1 b;
    private Integer c;
    private Integer d;
    private String e;
    
    private Map<B, T2> f;
    private Map<B, U2> g;
    private Map<B, C3> h;
    private Map<B, D3> i;
    private Map<B, Integer> j;
    private Map<B, Integer> k;
    private Map<B, E3> l;
    
    private String m;
    
    @Id
    @SpaceId(autoGenerate = false)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public B getA() {
        return a;
    }
    public void setA(B a) {
        this.a = a;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public Y1 getB() {
        return b;
    }
    public void setB(Y1 b) {
        this.b = b;
    }
    public Integer getC() {
        return c;
    }
    public void setC(Integer c) {
        this.c = c;
    }
    public Integer getD() {
        return d;
    }
    public void setD(Integer d) {
        this.d = d;
    }
    public String getE() {
        return e;
    }
    public void setE(String e) {
        this.e = e;
    }
    @Transient
    public Map<B, T2> getF() {
        return f;
    }
    public void setF(Map<B, T2> f) {
        this.f = f;
    }
    @Transient
    public Map<B, U2> getG() {
        return g;
    }
    public void setG(Map<B, U2> g) {
        this.g = g;
    }
    @Transient
    public Map<B, C3> getH() {
        return h;
    }
    public void setH(Map<B, C3> h) {
        this.h = h;
    }
    @Transient
    public Map<B, D3> getI() {
        return i;
    }
    public void setI(Map<B, D3> i) {
        this.i = i;
    }
    @Transient
    public Map<B, Integer> getJ() {
        return j;
    }
    public void setJ(Map<B, Integer> j) {
        this.j = j;
    }
    @Transient
    public Map<B, Integer> getK() {
        return k;
    }
    public void setK(Map<B, Integer> k) {
        this.k = k;
    }
    @Transient
    public Map<B, E3> getL() {
        return l;
    }
    public void setL(Map<B, E3> l) {
        this.l = l;
    }
    public String getM() {
        return m;
    }
    public void setM(String m) {
        this.m = m;
    }
}