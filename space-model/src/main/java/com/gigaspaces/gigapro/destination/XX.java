package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "XX", schema = "DBO")
public class XX {
    private String id;
    private GG a;
    private Date b;
    private Date c;
    private Date d;
    private String e;
    private String f;
    private Integer g;
    private Boolean h;
    private Boolean i;
    private Integer j;
    private String k;
    
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
    public GG getA() {
        return a;
    }
    public void setA(GG a) {
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
    public Integer getG() {
        return g;
    }
    public void setG(Integer g) {
        this.g = g;
    }
    public Boolean getH() {
        return h;
    }
    public void setH(Boolean h) {
        this.h = h;
    }
    public Boolean getI() {
        return i;
    }
    public void setI(Boolean i) {
        this.i = i;
    }
    public Integer getJ() {
        return j;
    }
    public void setJ(Integer j) {
        this.j = j;
    }
    public String getK() {
        return k;
    }
    public void setK(String k) {
        this.k = k;
    }
}