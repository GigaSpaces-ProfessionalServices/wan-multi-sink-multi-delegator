package com.gigaspaces.gigapro.source;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "J", schema = "DBO")
public class J {
    private String id;
    private D a;
    
    @SpaceId(autoGenerate = false)
    @Id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public D getA() {
        return a;
    }
    public void setA(D a) {
        this.a = a;
    }
}
