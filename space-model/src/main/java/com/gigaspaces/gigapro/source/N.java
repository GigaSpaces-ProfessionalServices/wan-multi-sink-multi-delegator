package com.gigaspaces.gigapro.source;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "N", schema = "DBO")
public class N {
    private String id;
    private D application;
    
    @Id
    @SpaceId(autoGenerate = false)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public D getApplication() {
        return application;
    }
    public void setApplication(D application) {
        this.application = application;
    }
}
