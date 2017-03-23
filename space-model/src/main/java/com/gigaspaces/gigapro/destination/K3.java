package com.gigaspaces.gigapro.destination;
import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "K3", schema = "DBO")
@SpaceClass
public class K3 {
    private String id;
    private Y2 a;
    private String b;
    private Date c;
    private Long d;
    private Long e;
    private Long f;
    private Long g;
    private Long h;
    private Long i;
    private Long j;
    private Date k;
    private Date l;
    private Date m;
    private Date n;
    private Date o;
    private Date p;
    private Date q;
    private Date r;
    private Long s;
    private Long t;
    private Date u;
    private Date v;
    private Date w;
    private Date x;
    private Date y;
    private Date z;
    private Date a1;
    private Date b1;
    private Integer c1;
    private Date d1;
    private Date e1;
    private Date f1;
    private Date g1;
    private Date h1;
    private Integer i1;
    private Integer j1;
    private Integer k1;
    private Integer l1;
    private Integer m1;
    private Date n1;
    private Integer o1;
    private Integer p1;
    private Integer q1;
    
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
    public Y2 getA() {
        return a;
    }
    public void setA(Y2 a) {
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
    public Long getD() {
        return d;
    }
    public void setD(Long d) {
        this.d = d;
    }
    public Long getE() {
        return e;
    }
    public void setE(Long e) {
        this.e = e;
    }
    public Long getF() {
        return f;
    }
    public void setF(Long f) {
        this.f = f;
    }
    public Long getG() {
        return g;
    }
    public void setG(Long g) {
        this.g = g;
    }
    public Long getH() {
        return h;
    }
    public void setH(Long h) {
        this.h = h;
    }
    public Long getI() {
        return i;
    }
    public void setI(Long i) {
        this.i = i;
    }
    public Long getJ() {
        return j;
    }
    public void setJ(Long j) {
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
    public Date getP() {
        return p;
    }
    public void setP(Date p) {
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
    public Long getS() {
        return s;
    }
    public void setS(Long s) {
        this.s = s;
    }
    public Long getT() {
        return t;
    }
    public void setT(Long t) {
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
    public Date getY() {
        return y;
    }
    public void setY(Date y) {
        this.y = y;
    }
    public Date getZ() {
        return z;
    }
    public void setZ(Date z) {
        this.z = z;
    }
    public Date getA1() {
        return a1;
    }
    public void setA1(Date a1) {
        this.a1 = a1;
    }
    public Date getB1() {
        return b1;
    }
    public void setB1(Date b1) {
        this.b1 = b1;
    }
    public Integer getC1() {
        return c1;
    }
    public void setC1(Integer c1) {
        this.c1 = c1;
    }
    public Date getD1() {
        return d1;
    }
    public void setD1(Date d1) {
        this.d1 = d1;
    }
    public Date getE1() {
        return e1;
    }
    public void setE1(Date e1) {
        this.e1 = e1;
    }
    public Date getF1() {
        return f1;
    }
    public void setF1(Date f1) {
        this.f1 = f1;
    }
    public Date getG1() {
        return g1;
    }
    public void setG1(Date g1) {
        this.g1 = g1;
    }
    public Date getH1() {
        return h1;
    }
    public void setH1(Date h1) {
        this.h1 = h1;
    }
    public Integer getI1() {
        return i1;
    }
    public void setI1(Integer i1) {
        this.i1 = i1;
    }
    public Integer getJ1() {
        return j1;
    }
    public void setJ1(Integer j1) {
        this.j1 = j1;
    }
    public Integer getK1() {
        return k1;
    }
    public void setK1(Integer k1) {
        this.k1 = k1;
    }
    public Integer getL1() {
        return l1;
    }
    public void setL1(Integer l1) {
        this.l1 = l1;
    }
    public Integer getM1() {
        return m1;
    }
    public void setM1(Integer m1) {
        this.m1 = m1;
    }
    public Date getN1() {
        return n1;
    }
    public void setN1(Date n1) {
        this.n1 = n1;
    }
    public Integer getO1() {
        return o1;
    }
    public void setO1(Integer o1) {
        this.o1 = o1;
    }
    public Integer getP1() {
        return p1;
    }
    public void setP1(Integer p1) {
        this.p1 = p1;
    }
    public Integer getQ1() {
        return q1;
    }
    public void setQ1(Integer q1) {
        this.q1 = q1;
    }
}