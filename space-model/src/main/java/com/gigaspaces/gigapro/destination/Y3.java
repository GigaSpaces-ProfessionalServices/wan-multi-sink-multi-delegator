package com.gigaspaces.gigapro.destination;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Map;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "Y3", schema = "DBO")
public class Y3 {
    private String id;
    private String a;
    private X3 b;
    private B c;
    private B d;
    private Integer e;
    private String f;
    private String g;
    private R3 h;
    private Integer i;
    private Integer j;
    private Integer k;
    private Integer l;
    private Integer m;
    private String n;
    private Boolean o;
    private Boolean p;
    private Boolean q;
    private Boolean r;
    private Boolean s;
    private Integer t;
    private Integer u;
    private Integer v;
    private String w;
    private Map<String, Integer> x;

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
    public X3 getB() {
        return b;
    }

    public void setB(X3 b) {
        this.b = b;
    }

    @ManyToOne(cascade = {CascadeType.MERGE})
    public B getC() {
        return c;
    }

    public void setC(B c) {
        this.c = c;
    }
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    public B getD() {
        return d;
    }

    public void setD(B d) {
        this.d = d;
    }

    public Integer getE() {
        return e;
    }

    public void setE(Integer e) {
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

    @ManyToOne(cascade = {CascadeType.MERGE})
    public R3 getH() {
        return h;
    }

    public void setH(R3 h) {
        this.h = h;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }

    public Integer getK() {
        return k;
    }

    public void setK(Integer k) {
        this.k = k;
    }

    public Integer getL() {
        return l;
    }

    public void setL(Integer l) {
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

    public Boolean getO() {
        return o;
    }

    public void setO(Boolean o) {
        this.o = o;
    }

    public Boolean getP() {
        return p;
    }

    public void setP(Boolean p) {
        this.p = p;
    }

    public Boolean getQ() {
        return q;
    }

    public void setQ(Boolean q) {
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

    public Integer getT() {
        return t;
    }

    public void setT(Integer t) {
        this.t = t;
    }

    public Integer getU() {
        return u;
    }

    public void setU(Integer u) {
        this.u = u;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    @Transient
    public Map<String, Integer> getX() {
        return x;
    }

    public void setX(Map<String, Integer> x) {
        this.x = x;
    }
}