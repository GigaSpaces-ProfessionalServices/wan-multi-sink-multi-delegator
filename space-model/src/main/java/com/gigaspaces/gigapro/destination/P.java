package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "P", schema = "DBO")
public class P {
    private String id;
    protected B a;
    protected B b;
    protected B c;
    protected B d;
    protected String e;
    protected String f;
    
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
    public B getA() {
        return a;
    }
    public void setA(B a) {
        this.a = a;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public B getB() {
        return b;
    }
    public void setB(B b) {
        this.b = b;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public B getC() {
        return c;
    }
    public void setC(B c) {
        this.c = c;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public B getD() {
        return d;
    }
    public void setD(B d) {
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
}