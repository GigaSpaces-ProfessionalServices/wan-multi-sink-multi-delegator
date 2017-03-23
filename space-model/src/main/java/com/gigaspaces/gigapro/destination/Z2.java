package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "Z2", schema = "DBO")
public class Z2 {
    private String id;
    private String a;
    private String b;
    private String c;
    private String d;
    private J2 e;
    private B f;
    private Date g;

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

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public J2 getE() {
        return e;
    }

    public void setE(J2 e) {
        this.e = e;
    }

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public B getF() {
        return f;
    }

    public void setF(B f) {
        this.f = f;
    }

    public Date getG() {
        return g;
    }

    public void setG(Date g) {
        this.g = g;
    }
}