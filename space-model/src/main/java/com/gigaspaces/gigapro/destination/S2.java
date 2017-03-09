package com.gigaspaces.gigapro.destination;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "S2", schema = "DBO")
public class S2 {

    private String id;
    private B a;
    private T2 b;
    private U2 c;
    private V2 d;

    @SpaceId(autoGenerate = false)
    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public B getA() {
        return a;
    }

    public void setA(B a) {
        this.a = a;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public T2 getB() {
        return b;
    }

    public void setB(T2 b) {
        this.b = b;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public U2 getC() {
        return c;
    }

    public void setC(U2 c) {
        this.c = c;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public V2 getD() {
        return d;
    }

    public void setD(V2 d) {
        this.d = d;
    }
}
