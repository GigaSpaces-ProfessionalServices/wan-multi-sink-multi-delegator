package com.gigaspaces.gigapro.destination;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;
import java.util.Map;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "S3", schema = "DBO")
public class S3 {
    private String id;
    private R3 a;
    private String b;
    private String c;
    private Boolean d;
    private Boolean e;
    private Map<B, Date> f;
    private Map<String, Integer> g;
    private String h;
    private String i;
    private String j;
    private Integer k;
    private String l;
    private Integer m;
    
    @SpaceId(autoGenerate = false)
    @Id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public R3 getA() {
        return a;
    }
    public void setA(R3 a) {
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
    public Boolean getD() {
        return d;
    }
    public void setD(Boolean d) {
        this.d = d;
    }
    public Boolean getE() {
        return e;
    }
    public void setE(Boolean e) {
        this.e = e;
    }
    @Transient
    public Map<B, Date> getF() {
        return f;
    }
    public void setF(Map<B, Date> f) {
        this.f = f;
    }
    @Transient
    public Map<String, Integer> getG() {
        return g;
    }
    public void setG(Map<String, Integer> g) {
        this.g = g;
    }
    public String getH() {
        return h;
    }
    public void setH(String h) {
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
}