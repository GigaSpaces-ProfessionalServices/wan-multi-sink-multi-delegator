package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "R", schema = "DBO")
public class R {
    private String id;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private B i;
    private B j;
    private String k;
    private String l;
    private Date m;
    private String n;
    private Date o;
    private String p;
    private Date q;
    private String r;
    private Date s;
    private String t;
    private Date u;
    private String v;
    private Date w;
    private String x;
    private String y;
    private Date z;
    private String aa;
    private Date bb;
    private String cc;
    private Date dd;
    private String ee;
    private Date ff;
    private String gg;
    private Date hh;
    private String ii;
    private Date kk;
    private String ll;
    private Date mm;
    private String nn;
    private String oo;
    private String pp;
    private String qq;
    private String rr;
    private String ss;
    private String tt;
    private String uu;
    private Boolean vv;
    private Boolean ww;
    private Boolean xx;
    
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
    public String getG() {
        return g;
    }
    public void setG(String g) {
        this.g = g;
    }
    public String getH() {
        return h;
    }
    public void setH(String h) {
        this.h = h;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public B getI() {
        return i;
    }
    public void setI(B i) {
        this.i = i;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public B getJ() {
        return j;
    }
    public void setJ(B j) {
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
    public Date getZ() {
        return z;
    }
    public void setZ(Date z) {
        this.z = z;
    }
    public String getAa() {
        return aa;
    }
    public void setAa(String aa) {
        this.aa = aa;
    }
    public Date getBb() {
        return bb;
    }
    public void setBb(Date bb) {
        this.bb = bb;
    }
    public String getCc() {
        return cc;
    }
    public void setCc(String cc) {
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
    public Date getFf() {
        return ff;
    }
    public void setFf(Date ff) {
        this.ff = ff;
    }
    public String getGg() {
        return gg;
    }
    public void setGg(String gg) {
        this.gg = gg;
    }
    public Date getHh() {
        return hh;
    }
    public void setHh(Date hh) {
        this.hh = hh;
    }
    public String getIi() {
        return ii;
    }
    public void setIi(String ii) {
        this.ii = ii;
    }
    public Date getKk() {
        return kk;
    }
    public void setKk(Date kk) {
        this.kk = kk;
    }
    public String getLl() {
        return ll;
    }
    public void setLl(String ll) {
        this.ll = ll;
    }
    public Date getMm() {
        return mm;
    }
    public void setMm(Date mm) {
        this.mm = mm;
    }
    public String getNn() {
        return nn;
    }
    public void setNn(String nn) {
        this.nn = nn;
    }
    public String getOo() {
        return oo;
    }
    public void setOo(String oo) {
        this.oo = oo;
    }
    public String getPp() {
        return pp;
    }
    public void setPp(String pp) {
        this.pp = pp;
    }
    public String getQq() {
        return qq;
    }
    public void setQq(String qq) {
        this.qq = qq;
    }
    public String getRr() {
        return rr;
    }
    public void setRr(String rr) {
        this.rr = rr;
    }
    public String getSs() {
        return ss;
    }
    public void setSs(String ss) {
        this.ss = ss;
    }
    public String getTt() {
        return tt;
    }
    public void setTt(String tt) {
        this.tt = tt;
    }
    public String getUu() {
        return uu;
    }
    public void setUu(String uu) {
        this.uu = uu;
    }
    public Boolean getVv() {
        return vv;
    }
    public void setVv(Boolean vv) {
        this.vv = vv;
    }
    public Boolean getWw() {
        return ww;
    }
    public void setWw(Boolean ww) {
        this.ww = ww;
    }
    public Boolean getXx() {
        return xx;
    }
    public void setXx(Boolean xx) {
        this.xx = xx;
    }
}