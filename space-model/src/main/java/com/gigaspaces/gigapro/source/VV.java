package com.gigaspaces.gigapro.source;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "VV", schema = "DBO")
public class VV {
    private String id;
    private II a;
    private Date b;
    private Date c;
    private Date d;
    private Integer e;
    private Integer f;
    private String g;
    private Date h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private Integer p;
    private UU q;
    private QQ r;
    
    @SpaceId(autoGenerate = false)
    @Id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public II getA() {
        return a;
    }
    public void setA(II a) {
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
    public Date getD() {
        return d;
    }
    public void setD(Date d) {
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
    public Integer getP() {
        return p;
    }
    public void setP(Integer p) {
        this.p = p;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public UU getQ() {
        return q;
    }
    public void setQ(UU q) {
        this.q = q;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public QQ getR() {
        return r;
    }
    public void setR(QQ r) {
        this.r = r;
    }
}   