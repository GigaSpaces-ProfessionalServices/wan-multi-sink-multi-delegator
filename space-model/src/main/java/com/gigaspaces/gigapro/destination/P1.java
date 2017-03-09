package com.gigaspaces.gigapro.destination;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "P1", schema = "DBO")
public class P1 {
    
    private String id;
    private EE a;
    private Date b;
    private Date c;
    private String d;
    private Date e;
    private Date f;
    private String g;
    private Date h;
    private Date i;
    private String j;
    private Date k;
    private Date l;
    private String m;
    private Date n;
    private Date o;
    private String p;
    private Date q;
    private Date r;
    private String s;
    private Date t;
    private Date u;
    private String v;
    private Date w;
    private Date x;
    private String y;
    private Date z;
    private Date aa;
    private String bb;
    private Date cc;
    private Date dd;
    private String ee;

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

    public Date getF() {
        return f;
    }

    public void setF(Date f) {
        this.f = f;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
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

    public String getJ() {
        return j;
    }

    public void setJ(String j) {
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

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public Date getN() {
        return n;
    }

    public void setN(Date n) {
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

    public Date getR() {
        return r;
    }

    public void setR(Date r) {
        this.r = r;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
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

    public Date getX() {
        return x;
    }

    public void setX(Date x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public Date getZ() {
        return z;
    }

    public void setZ(Date z) {
        this.z = z;
    }

    public Date getAa() {
        return aa;
    }

    public void setAa(Date aa) {
        this.aa = aa;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public Date getCc() {
        return cc;
    }

    public void setCc(Date cc) {
        this.cc = cc;
    }

    public Date getDd() {
        return dd;
    }

    public void setDd(Date dd) {
        this.dd = dd;
    }

    public String getEe() {
        return ee;
    }

    public void setEe(String ee) {
        this.ee = ee;
    }
}