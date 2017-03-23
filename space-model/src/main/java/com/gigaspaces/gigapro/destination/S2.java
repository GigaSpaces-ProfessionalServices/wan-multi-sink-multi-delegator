package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

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
    public T2 getB() {
        return b;
    }

    public void setB(T2 b) {
        this.b = b;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public U2 getC() {
        return c;
    }

    public void setC(U2 c) {
        this.c = c;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public V2 getD() {
        return d;
    }

    public void setD(V2 d) {
        this.d = d;
    }
}
