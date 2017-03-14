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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((application == null) ? 0 : application.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        N other = (N) obj;
        if (application == null) {
            if (other.application != null)
                return false;
        } else if (!application.equals(other.application))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "N [id=" + id + ", application=" + application + "]";
    }
}
