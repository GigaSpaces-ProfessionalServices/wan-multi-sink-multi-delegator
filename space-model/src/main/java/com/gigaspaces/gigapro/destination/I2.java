package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "I2", schema = "DBO")
@SpaceClass
public class I2 {
    private String id;
    private G2 a;
    private String b;
    private H2 c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private Date j;
    private Date k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private Date w;
    private String x;
    
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
    public G2 getA() {
        return a;
    }
    public void setA(G2 a) {
        this.a = a;
    }
    public String getB() {
        return b;
    }
    public void setB(String b) {
        this.b = b;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public H2 getC() {
        return c;
    }
    public void setC(H2 c) {
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
    public Date getJ() {
        return j;
    }
    public void setJ(Date j) {
        this.j = j;
    }
    public Date getK() {
        return k;
    }
    public void setK(Date k) {
        this.k = k;
    }
    public String getL() {
        return l;
    }
    public void setL(String l) {
        this.l = l;
    }
    public String getM() {
        return m;
    }
    public void setM(String m) {
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
    public String getR() {
        return r;
    }
    public void setR(String r) {
        this.r = r;
    }
    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }
    public String getT() {
        return t;
    }
    public void setT(String t) {
        this.t = t;
    }
    public String getU() {
        return u;
    }
    public void setU(String u) {
        this.u = u;
    }
    public String getV() {
        return v;
    }
    public void setV(String v) {
        this.v = v;
    }
    public Date getW() {
        return w;
    }
    public void setW(Date w) {
        this.w = w;
    }
    public String getX() {
        return x;
    }
    public void setX(String x) {
        this.x = x;
    }
}