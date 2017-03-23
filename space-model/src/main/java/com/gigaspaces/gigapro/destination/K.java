package com.gigaspaces.gigapro.destination;
import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "K", schema = "DBO")
public class K {
    private String id;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Date f;
    private Date g;
    private Integer h;
    private List<H> i;
    private String j;
    
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
    public Date getF() {
        return f;
    }
    public void setF(Date f) {
        this.f = f;
    }
    public Date getG() {
        return g;
    }
    public void setG(Date g) {
        this.g = g;
    }
    public Integer getH() {
        return h;
    }
    public void setH(Integer h) {
        this.h = h;
    }
    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public List<H> getI() {
        return i;
    }
    public void setI(List<H> i) {
        this.i = i;
    }
    public String getJ() {
        return j;
    }
    public void setJ(String j) {
        this.j = j;
    }
}
