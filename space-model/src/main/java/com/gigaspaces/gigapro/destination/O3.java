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
@Table(name = "O3", schema = "DBO")
public class O3 {
    private String id;
    private BigInteger a;
    private Date b;
    private BigInteger c;
    private Date d;
    private BigInteger e;
    private Date f;
    private BigInteger g;
    private Date h;
    
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
    public BigInteger getC() {
        return c;
    }
    public void setC(BigInteger c) {
        this.c = c;
    }
    public Date getD() {
        return d;
    }
    public void setD(Date d) {
        this.d = d;
    }
    public BigInteger getE() {
        return e;
    }
    public void setE(BigInteger e) {
        this.e = e;
    }
    public Date getF() {
        return f;
    }
    public void setF(Date f) {
        this.f = f;
    }
    public BigInteger getG() {
        return g;
    }
    public void setG(BigInteger g) {
        this.g = g;
    }
    public Date getH() {
        return h;
    }
    public void setH(Date h) {
        this.h = h;
    }
}