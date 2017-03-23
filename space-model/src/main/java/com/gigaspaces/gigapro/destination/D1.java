package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "D1", schema = "DBO")
public class D1 {
    private String id;
    
    private EE a;
    private Date b;
    private String c;
    
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
    public EE getA() {
        return a;
    }
    public void setA(EE a) {
        this.a = a;
    }
    public Date getB() {
        return b;
    }
    public void setB(Date b) {
        this.b = b;
    }
    public String getC() {
        return c;
    }
    public void setC(String c) {
        this.c = c;
    }
}