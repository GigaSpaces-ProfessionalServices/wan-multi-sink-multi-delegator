package com.gigaspaces.gigapro.destination;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "RR", schema = "DBO")
public class RR {
    private String id;
    private EE a;
    private Date b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Date g;
    private Date h;
    private Date i;
    private Date j;
    private Date k;
    private Date l;
    private Date m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private Date s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    
    @Id
    @SpaceId(autoGenerate = false)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public EE getA() {
        return a;
    }
    public void setA(EE a) {
        this.a = a;
    }
    public Date getB() {
        return b;
    }
    public void setB(Date b) {
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
    public Date getI() {
        return i;
    }
    public void setI(Date i) {
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
    public Date getL() {
        return l;
    }
    public void setL(Date l) {
        this.l = l;
    }
    public Date getM() {
        return m;
    }
    public void setM(Date m) {
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
    public Date getS() {
        return s;
    }
    public void setS(Date s) {
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
    public String getW() {
        return w;
    }
    public void setW(String w) {
        this.w = w;
    }
    public String getX() {
        return x;
    }
    public void setX(String x) {
        this.x = x;
    }
}