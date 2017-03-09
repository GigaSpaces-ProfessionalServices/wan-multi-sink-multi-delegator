package com.gigaspaces.gigapro.destination;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SpaceClass
@Entity
@Table(name = "P2", schema = "DBO")
public class P2 {
    private String id;
    private Integer a;
    private Date b;
    private Date c;
    private String d;
    private Long e;
    private Boolean f;
    
    @Id
    @SpaceId(autoGenerate = false)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getA() {
        return a;
    }
    public void setA(Integer a) {
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
    public String getD() {
        return d;
    }
    public void setD(String d) {
        this.d = d;
    }
    public Long getE() {
        return e;
    }
    public void setE(Long e) {
        this.e = e;
    }
    public Boolean getF() {
        return f;
    }
    public void setF(Boolean f) {
        this.f = f;
    }
}