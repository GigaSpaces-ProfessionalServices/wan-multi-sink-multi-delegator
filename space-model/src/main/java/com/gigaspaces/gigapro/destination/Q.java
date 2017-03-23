package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "Q", schema = "DBO")
public class Q {
    private String id;
    private String a;
    private String b;
    private String c;
    private Date d;
    private Date e;
    private String f;
    private B g;
    
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
    public String getF() {
        return f;
    }
    public void setF(String f) {
        this.f = f;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public B getG() {
        return g;
    }
    public void setG(B g) {
        this.g = g;
    }
}