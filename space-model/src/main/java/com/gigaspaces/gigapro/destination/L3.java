package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "L3", schema = "DBO")
public class L3 {
    private String id;
    private String a;
    private String  b;
    private String c;
    private String d;
    private Integer e;
    private Integer f;
    private Integer g;
    private Integer h;
    private Integer i;
    private String j;
    private Integer k;
    private String l;
    private String m;
    private String n;
    private Integer o;
    private Integer p;
    private String q;
    private String r;
    private String s;
    private String t;
    private Boolean u;
    private Boolean v;
    private Boolean w;
    private Integer x;
    private Integer y;
    private Integer z;
    private String a1;
    private String b1;
    private Date c1;
    private String d1;
    private Integer e1;
    private B f1;
    private Date g1;
    private String h1;
    private String i1;
    private String j1;
    
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
    public String getD() {
        return d;
    }
    public void setD(String d) {
        this.d = d;
    }
    public Integer getE() {
        return e;
    }
    public void setE(Integer e) {
        this.e = e;
    }
    public Integer getF() {
        return f;
    }
    public void setF(Integer f) {
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
    public Integer getI() {
        return i;
    }
    public void setI(Integer i) {
        this.i = i;
    }
    public String getJ() {
        return j;
    }
    public void setJ(String j) {
        this.j = j;
    }
    public Integer getK() {
        return k;
    }
    public void setK(Integer k) {
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
    public Integer getO() {
        return o;
    }
    public void setO(Integer o) {
        this.o = o;
    }
    public Integer getP() {
        return p;
    }
    public void setP(Integer p) {
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
    public Boolean getU() {
        return u;
    }
    public void setU(Boolean u) {
        this.u = u;
    }
    public Boolean getV() {
        return v;
    }
    public void setV(Boolean v) {
        this.v = v;
    }
    public Boolean getW() {
        return w;
    }
    public void setW(Boolean w) {
        this.w = w;
    }
    public Integer getX() {
        return x;
    }
    public void setX(Integer x) {
        this.x = x;
    }
    public Integer getY() {
        return y;
    }
    public void setY(Integer y) {
        this.y = y;
    }
    public Integer getZ() {
        return z;
    }
    public void setZ(Integer z) {
        this.z = z;
    }
    public String getA1() {
        return a1;
    }
    public void setA1(String a1) {
        this.a1 = a1;
    }
    public String getB1() {
        return b1;
    }
    public void setB1(String b1) {
        this.b1 = b1;
    }
    public Date getC1() {
        return c1;
    }
    public void setC1(Date c1) {
        this.c1 = c1;
    }
    public String getD1() {
        return d1;
    }
    public void setD1(String d1) {
        this.d1 = d1;
    }
    public Integer getE1() {
        return e1;
    }
    public void setE1(Integer e1) {
        this.e1 = e1;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public B getF1() {
        return f1;
    }
    public void setF1(B f1) {
        this.f1 = f1;
    }
    public Date getG1() {
        return g1;
    }
    public void setG1(Date g1) {
        this.g1 = g1;
    }
    public String getH1() {
        return h1;
    }
    public void setH1(String h1) {
        this.h1 = h1;
    }
    public String getI1() {
        return i1;
    }
    public void setI1(String i1) {
        this.i1 = i1;
    }
    public String getJ1() {
        return j1;
    }
    public void setJ1(String j1) {
        this.j1 = j1;
    }
}