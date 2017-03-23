package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "V3", schema = "DBO")
public class V3 {
    private String id;
    private W3 a;
    private String b1;
    private B b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private Integer m;
    private String n;
    private String o;
    private String p;
    private String q;
    private Boolean r;
    private Boolean s;
    private Boolean t;
    private Boolean u;
    private String v;
    private T3 w;
    private T3 x;
    
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
    public W3 getA() {
        return a;
    }
    public void setA(W3 a) {
        this.a = a;
    }
    public String getB1() {
        return b1;
    }
    public void setB1(String b) {
        this.b1 = b;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public B getB() {
        return b;
    }
    public void setB(B b) {
        this.b = b;
    }
    public String getC() {
        return c;
    }
    public void setC(String c) {
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
    public String getF() {
        return f;
    }
    public void setF(String f) {
        this.f = f;
    }
    public String getG() {
        return g;
    }
    public void setG(String g) {
        this.g = g;
    }
    public String getH() {
        return h;
    }
    public void setH(String h) {
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
    public String getK() {
        return k;
    }
    public void setK(String k) {
        this.k = k;
    }
    public String getL() {
        return l;
    }
    public void setL(String l) {
        this.l = l;
    }
    public Integer getM() {
        return m;
    }
    public void setM(Integer m) {
        this.m = m;
    }
    public String getN() {
        return n;
    }
    public void setN(String n) {
        this.n = n;
    }
    public String getO() {
        return o;
    }
    public void setO(String o) {
        this.o = o;
    }
    public String getP() {
        return p;
    }
    public void setP(String p) {
        this.p = p;
    }
    public String getQ() {
        return q;
    }
    public void setQ(String q) {
        this.q = q;
    }
    public Boolean getR() {
        return r;
    }
    public void setR(Boolean r) {
        this.r = r;
    }
    public Boolean getS() {
        return s;
    }
    public void setS(Boolean s) {
        this.s = s;
    }
    public Boolean getT() {
        return t;
    }
    public void setT(Boolean t) {
        this.t = t;
    }
    public Boolean getU() {
        return u;
    }
    public void setU(Boolean u) {
        this.u = u;
    }
    public String getV() {
        return v;
    }
    public void setV(String v) {
        this.v = v;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public T3 getW() {
        return w;
    }
    public void setW(T3 w) {
        this.w = w;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public T3 getX() {
        return x;
    }
    public void setX(T3 x) {
        this.x = x;
    }
}