package com.gigaspaces.gigapro.destination;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "D2", schema = "DBO")
public class D2 {
    private String id;
    
    private A2 a;
    private String b;
    private Integer c;
    private String d;
    private String e;
    private Integer f;
    private Integer g;
    private Integer h;
    private String i;
    private String j;
    private Integer k;
    private Integer l;
    private String m;
    private String n;
    private B o;
    private B p;
    private C2 q;
    private String r;
    private Integer s;
    private Date t;
    private Date u;
    private Date v;
    private String w;
    private String x;
    private String y;
    private String z;
    private Boolean a1;
    private Boolean b1;
    private String c1;
    
    @Id
    @SpaceId(autoGenerate = false)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public A2 getA() {
        return a;
    }
    public void setA(A2 a) {
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
    public String getE() {
        return e;
    }
    public void setE(String e) {
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
    @ManyToOne(cascade = {CascadeType.MERGE})
    public B getO() {
        return o;
    }
    public void setO(B o) {
        this.o = o;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public B getP() {
        return p;
    }
    public void setP(B p) {
        this.p = p;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public C2 getQ() {
        return q;
    }
    public void setQ(C2 q) {
        this.q = q;
    }
    public String getR() {
        return r;
    }
    public void setR(String r) {
        this.r = r;
    }
    public Integer getS() {
        return s;
    }
    public void setS(Integer s) {
        this.s = s;
    }
    public Date getT() {
        return t;
    }
    public void setT(Date t) {
        this.t = t;
    }
    public Date getU() {
        return u;
    }
    public void setU(Date u) {
        this.u = u;
    }
    public Date getV() {
        return v;
    }
    public void setV(Date v) {
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
    public String getY() {
        return y;
    }
    public void setY(String y) {
        this.y = y;
    }
    public String getZ() {
        return z;
    }
    public void setZ(String z) {
        this.z = z;
    }
    public Boolean getA1() {
        return a1;
    }
    public void setA1(Boolean a1) {
        this.a1 = a1;
    }
    public Boolean getB1() {
        return b1;
    }
    public void setB1(Boolean b1) {
        this.b1 = b1;
    }
    public String getC1() {
        return c1;
    }
    public void setC1(String c1) {
        this.c1 = c1;
    }
}