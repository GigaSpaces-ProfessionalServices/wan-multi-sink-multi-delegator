package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "N2", schema = "DBO")
public class N2 {
    
    private String id;
    private Y1 a;
    private Date b;
    private String c;
    private Date d;
    private Date e;
    private Boolean f;
    private Date g;
    private Date h;
    private Integer i;
    private Integer j;
    private Integer k;
    private String l;
    private Integer m;
    private Integer n;
    private Boolean o;
    private Boolean p;
    private List<M2> q;
    private F2 r;
    private Date s;
    private Date t;
    private String u;
    private Boolean v;
    private Boolean w;
    private Date x;
    private Date y;
    private Boolean z;
    
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
    public Y1 getA() {
        return a;
    }
    public void setA(Y1 a) {
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
    public Boolean getF() {
        return f;
    }
    public void setF(Boolean f) {
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
    public Integer getN() {
        return n;
    }
    public void setN(Integer n) {
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
    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public List<M2> getQ() {
        return q;
    }
    public void setQ(List<M2> q) {
        this.q = q;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public F2 getR() {
        return r;
    }
    public void setR(F2 r) {
        this.r = r;
    }
    public Date getS() {
        return s;
    }
    public void setS(Date s) {
        this.s = s;
    }
    public Date getT() {
        return t;
    }
    public void setT(Date t) {
        this.t = t;
    }
    public String getU() {
        return u;
    }
    public void setU(String u) {
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
    public Date getX() {
        return x;
    }
    public void setX(Date x) {
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
}