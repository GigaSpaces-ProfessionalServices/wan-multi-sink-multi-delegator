package com.gigaspaces.gigapro.source;

import org.hibernate.annotations.Cascade;

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
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public D getA() {
        return a;
    }
    public void setA(D a) {
        this.a = a;
    }
}
