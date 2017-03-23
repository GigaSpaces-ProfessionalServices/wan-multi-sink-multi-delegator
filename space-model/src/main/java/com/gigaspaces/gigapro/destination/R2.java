package com.gigaspaces.gigapro.destination;
import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "R2", schema = "DBO")
public class R2 {
    private String id;
    private J2 a;
    private Date b;
    private Date c;
    private Date d;
    private Integer e;
    private List<Q2> f;
    
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
    public J2 getA() {
        return a;
    }
    public void setA(J2 a) {
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
    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public List<Q2> getF() {
        return f;
    }
    public void setF(List<Q2> f) {
        this.f = f;
    }
}