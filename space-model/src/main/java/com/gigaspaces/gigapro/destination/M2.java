package com.gigaspaces.gigapro.destination;

import org.hibernate.annotations.Cascade;

import com.gigaspaces.annotation.pojo.SpaceClass;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "M2", schema = "DBO")
public class M2 implements Serializable {
    private String id;
    private B a;
    private String b;
    private String c;
    private Boolean d;
    private String e;
    private String f;
    private Integer g;
    private Integer h;
    private Integer i;
    private String j;
    private String k;
    private Integer l;
    private Integer m;
    private String n;
    private O2 o;
    private Integer p;
    private String q;
    private String r;
    private String s;
    private C2 t;
    private B u;
    private B v;
    private Y1 w;
    private Date x;
    private Date y;
    private String z;
    private String a1;
    private String b1;
    private String c1;
    private Boolean d1;
    private Boolean e1;
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
    public String getB() {
        return b;
    }
    public void setB(String b) {
        this.b = b;
    }
    public String getC() {
        return c;
    }
    public void setC(String c) {
        this.c = c;
    }
    public Boolean getD() {
        return d;
    }
    public void setD(Boolean d) {
        this.d = d;
    }
    public String getE() {
        return e;
    }
    public void setE(String e) {
        this.e = e;
    }
    public String getF() {
        return f;
    }
    public void setF(String f) {
        this.f = f;
    }
    public Integer getG() {
        return g;
    }
    public void setG(Integer g) {
        this.g = g;
    }
    public Integer getH() {
        return h;
    }
    public void setH(Integer h) {
        this.h = h;
    }
    public Integer getI() {
        return i;
    }
    public void setI(Integer i) {
        this.i = i;
    }
    public String getJ() {
        return j;
    }
    public void setJ(String j) {
        this.j = j;
    }
    public String getK() {
        return k;
    }
    public void setK(String k) {
        this.k = k;
    }
    public Integer getL() {
        return l;
    }
    public void setL(Integer l) {
        this.l = l;
    }
    public Integer getM() {
        return m;
    }
    public void setM(Integer m) {
        this.m = m;
    }
    public String getN() {
        return n;
    }
    public void setN(String n) {
        this.n = n;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public O2 getO() {
        return o;
    }
    public void setO(O2 o) {
        this.o = o;
    }
    public Integer getP() {
        return p;
    }
    public void setP(Integer p) {
        this.p = p;
    }
    public String getQ() {
        return q;
    }
    public void setQ(String q) {
        this.q = q;
    }
    public String getR() {
        return r;
    }
    public void setR(String r) {
        this.r = r;
    }
    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public C2 getT() {
        return t;
    }
    public void setT(C2 t) {
        this.t = t;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public B getU() {
        return u;
    }
    public void setU(B u) {
        this.u = u;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public B getV() {
        return v;
    }
    public void setV(B v) {
        this.v = v;
    }
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public Y1 getW() {
        return w;
    }
    public void setW(Y1 w) {
        this.w = w;
    }
    public Date getX() {
        return x;
    }
    public void setX(Date x) {
        this.x = x;
    }
    public Date getY() {
        return y;
    }
    public void setY(Date y) {
        this.y = y;
    }
    public String getZ() {
        return z;
    }
    public void setZ(String z) {
        this.z = z;
    }
    public String getA1() {
        return a1;
    }
    public void setA1(String a1) {
        this.a1 = a1;
    }
    public String getB1() {
        return b1;
    }
    public void setB1(String b1) {
        this.b1 = b1;
    }
    public String getC1() {
        return c1;
    }
    public void setC1(String c1) {
        this.c1 = c1;
    }
    public Boolean getD1() {
        return d1;
    }
    public void setD1(Boolean d1) {
        this.d1 = d1;
    }
    public Boolean getE1() {
        return e1;
    }
    public void setE1(Boolean e1) {
        this.e1 = e1;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((a == null) ? 0 : a.hashCode());
        result = prime * result + ((a1 == null) ? 0 : a1.hashCode());
        result = prime * result + ((b == null) ? 0 : b.hashCode());
        result = prime * result + ((b1 == null) ? 0 : b1.hashCode());
        result = prime * result + ((c == null) ? 0 : c.hashCode());
        result = prime * result + ((c1 == null) ? 0 : c1.hashCode());
        result = prime * result + ((d == null) ? 0 : d.hashCode());
        result = prime * result + ((d1 == null) ? 0 : d1.hashCode());
        result = prime * result + ((e == null) ? 0 : e.hashCode());
        result = prime * result + ((e1 == null) ? 0 : e1.hashCode());
        result = prime * result + ((f == null) ? 0 : f.hashCode());
        result = prime * result + ((g == null) ? 0 : g.hashCode());
        result = prime * result + ((h == null) ? 0 : h.hashCode());
        result = prime * result + ((i == null) ? 0 : i.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((j == null) ? 0 : j.hashCode());
        result = prime * result + ((k == null) ? 0 : k.hashCode());
        result = prime * result + ((l == null) ? 0 : l.hashCode());
        result = prime * result + ((m == null) ? 0 : m.hashCode());
        result = prime * result + ((n == null) ? 0 : n.hashCode());
        result = prime * result + ((o == null) ? 0 : o.hashCode());
        result = prime * result + ((p == null) ? 0 : p.hashCode());
        result = prime * result + ((q == null) ? 0 : q.hashCode());
        result = prime * result + ((r == null) ? 0 : r.hashCode());
        result = prime * result + ((s == null) ? 0 : s.hashCode());
        result = prime * result + ((t == null) ? 0 : t.hashCode());
        result = prime * result + ((u == null) ? 0 : u.hashCode());
        result = prime * result + ((v == null) ? 0 : v.hashCode());
        result = prime * result + ((w == null) ? 0 : w.hashCode());
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
        result = prime * result + ((z == null) ? 0 : z.hashCode());
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
        M2 other = (M2) obj;
        if (a == null) {
            if (other.a != null)
                return false;
        } else if (!a.equals(other.a))
            return false;
        if (a1 == null) {
            if (other.a1 != null)
                return false;
        } else if (!a1.equals(other.a1))
            return false;
        if (b == null) {
            if (other.b != null)
                return false;
        } else if (!b.equals(other.b))
            return false;
        if (b1 == null) {
            if (other.b1 != null)
                return false;
        } else if (!b1.equals(other.b1))
            return false;
        if (c == null) {
            if (other.c != null)
                return false;
        } else if (!c.equals(other.c))
            return false;
        if (c1 == null) {
            if (other.c1 != null)
                return false;
        } else if (!c1.equals(other.c1))
            return false;
        if (d == null) {
            if (other.d != null)
                return false;
        } else if (!d.equals(other.d))
            return false;
        if (d1 == null) {
            if (other.d1 != null)
                return false;
        } else if (!d1.equals(other.d1))
            return false;
        if (e == null) {
            if (other.e != null)
                return false;
        } else if (!e.equals(other.e))
            return false;
        if (e1 == null) {
            if (other.e1 != null)
                return false;
        } else if (!e1.equals(other.e1))
            return false;
        if (f == null) {
            if (other.f != null)
                return false;
        } else if (!f.equals(other.f))
            return false;
        if (g == null) {
            if (other.g != null)
                return false;
        } else if (!g.equals(other.g))
            return false;
        if (h == null) {
            if (other.h != null)
                return false;
        } else if (!h.equals(other.h))
            return false;
        if (i == null) {
            if (other.i != null)
                return false;
        } else if (!i.equals(other.i))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (j == null) {
            if (other.j != null)
                return false;
        } else if (!j.equals(other.j))
            return false;
        if (k == null) {
            if (other.k != null)
                return false;
        } else if (!k.equals(other.k))
            return false;
        if (l == null) {
            if (other.l != null)
                return false;
        } else if (!l.equals(other.l))
            return false;
        if (m == null) {
            if (other.m != null)
                return false;
        } else if (!m.equals(other.m))
            return false;
        if (n == null) {
            if (other.n != null)
                return false;
        } else if (!n.equals(other.n))
            return false;
        if (o == null) {
            if (other.o != null)
                return false;
        } else if (!o.equals(other.o))
            return false;
        if (p == null) {
            if (other.p != null)
                return false;
        } else if (!p.equals(other.p))
            return false;
        if (q == null) {
            if (other.q != null)
                return false;
        } else if (!q.equals(other.q))
            return false;
        if (r == null) {
            if (other.r != null)
                return false;
        } else if (!r.equals(other.r))
            return false;
        if (s == null) {
            if (other.s != null)
                return false;
        } else if (!s.equals(other.s))
            return false;
        if (t == null) {
            if (other.t != null)
                return false;
        } else if (!t.equals(other.t))
            return false;
        if (u == null) {
            if (other.u != null)
                return false;
        } else if (!u.equals(other.u))
            return false;
        if (v == null) {
            if (other.v != null)
                return false;
        } else if (!v.equals(other.v))
            return false;
        if (w == null) {
            if (other.w != null)
                return false;
        } else if (!w.equals(other.w))
            return false;
        if (x == null) {
            if (other.x != null)
                return false;
        } else if (!x.equals(other.x))
            return false;
        if (y == null) {
            if (other.y != null)
                return false;
        } else if (!y.equals(other.y))
            return false;
        if (z == null) {
            if (other.z != null)
                return false;
        } else if (!z.equals(other.z))
            return false;
        return true;
    }
}