package com.gigaspaces.gigapro.destination;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SpaceClass
@Entity
@Table(name = "M3", schema = "DBO")
public class M3 {
    private String id;
    private BigInteger a;
    private Date b;
    private Integer c;
    private Date d;
    private Integer e;
    private Date f;
    private Integer g;
    private Integer h;
    private Integer i;
    private Integer j;
    private Integer k;
    private Integer l;
    private Integer m;
    private Integer n;
    private Integer o;
    private Integer p;
    private String q;
    
    @Id
    @SpaceId(autoGenerate = false)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public BigInteger getA() {
        return a;
    }
    public void setA(BigInteger a) {
        this.a = a;
    }
    public Date getB() {
        return b;
    }
    public void setB(Date b) {
        this.b = b;
    }
    public Integer getC() {
        return c;
    }
    public void setC(Integer c) {
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
    public Date getF() {
        return f;
    }
    public void setF(Date f) {
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
    public Integer getN() {
        return n;
    }
    public void setN(Integer n) {
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
}