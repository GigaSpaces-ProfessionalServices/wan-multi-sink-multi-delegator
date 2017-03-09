package com.gigaspaces.gigapro.destination;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "D3", schema = "DBO")
public class D3 {
    private String id;
    
    private String a;
    private String b;
    private Date c;
    private String d;
    private Date e;
    private String f;
    private Date g;
    private String h;
    private Date i;
    private B j;
    private Date k;
    private B l;
    private Date m;
    private String n;
    private Date o;
    private String p;
    private Date q;
    private Integer r;
    private Date s;
    private String t;
    private Date u;
    private String v;
    private Date w;
    private Integer x;
    private Date y;
    private Boolean z;
    private Date a1;
    private Boolean b1;
    private Date c1;
    private Integer d1;
    private Date e1;
    
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
    public Date getC() {
        return c;
    }
    public void setC(Date c) {
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
    public Date getG() {
        return g;
    }
    public void setG(Date g) {
        this.g = g;
    }
    public String getH() {
        return h;
    }
    public void setH(String h) {
        this.h = h;
    }
    public Date getI() {
        return i;
    }
    public void setI(Date i) {
        this.i = i;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public B getJ() {
        return j;
    }
    public void setJ(B j) {
        this.j = j;
    }
    public Date getK() {
        return k;
    }
    public void setK(Date k) {
        this.k = k;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public B getL() {
        return l;
    }
    public void setL(B l) {
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
    public Date getO() {
        return o;
    }
    public void setO(Date o) {
        this.o = o;
    }
    public String getP() {
        return p;
    }
    public void setP(String p) {
        this.p = p;
    }
    public Date getQ() {
        return q;
    }
    public void setQ(Date q) {
        this.q = q;
    }
    public Integer getR() {
        return r;
    }
    public void setR(Integer r) {
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
    public Date getU() {
        return u;
    }
    public void setU(Date u) {
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
    public Integer getX() {
        return x;
    }
    public void setX(Integer x) {
        this.x = x;
    }
    public Date getY() {
        return y;
    }
    public void setY(Date y) {
        this.y = y;
    }
    public Boolean getZ() {
        return z;
    }
    public void setZ(Boolean z) {
        this.z = z;
    }
    public Date getA1() {
        return a1;
    }
    public void setA1(Date a1) {
        this.a1 = a1;
    }
    public Boolean getB1() {
        return b1;
    }
    public void setB1(Boolean b1) {
        this.b1 = b1;
    }
    public Date getC1() {
        return c1;
    }
    public void setC1(Date c1) {
        this.c1 = c1;
    }
    public Integer getD1() {
        return d1;
    }
    public void setD1(Integer d1) {
        this.d1 = d1;
    }
    public Date getE1() {
        return e1;
    }
    public void setE1(Date e1) {
        this.e1 = e1;
    }
}