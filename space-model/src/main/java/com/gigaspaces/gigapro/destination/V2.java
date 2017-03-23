package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "V2", schema = "DBO")
public class V2 implements Serializable {
    private String id;

    private Boolean a;
    private Boolean b;
    private Integer c;
    private Date d;
    private List<B> e;
    
    @Id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Boolean getA() {
        return a;
    }
    public void setA(Boolean a) {
        this.a = a;
    }
    public Boolean getB() {
        return b;
    }
    public void setB(Boolean b) {
        this.b = b;
    }
    public Integer getC() {
        return c;
    }
    public void setC(Integer c) {
        this.c = c;
    }
    public Date getD() {
        return d;
    }
    public void setD(Date d) {
        this.d = d;
    }
    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public List<B> getE() {
        return e;
    }
    public void setE(List<B> e) {
        this.e = e;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((a == null) ? 0 : a.hashCode());
        result = prime * result + ((b == null) ? 0 : b.hashCode());
        result = prime * result + ((c == null) ? 0 : c.hashCode());
        result = prime * result + ((d == null) ? 0 : d.hashCode());
        result = prime * result + ((e == null) ? 0 : e.hashCode());
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
        V2 other = (V2) obj;
        if (a == null) {
            if (other.a != null)
                return false;
        } else if (!a.equals(other.a))
            return false;
        if (b == null) {
            if (other.b != null)
                return false;
        } else if (!b.equals(other.b))
            return false;
        if (c == null) {
            if (other.c != null)
                return false;
        } else if (!c.equals(other.c))
            return false;
        if (d == null) {
            if (other.d != null)
                return false;
        } else if (!d.equals(other.d))
            return false;
        if (e == null) {
            if (other.e != null)
                return false;
        } else if (!e.equals(other.e))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}