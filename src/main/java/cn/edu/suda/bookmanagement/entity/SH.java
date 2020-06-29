package cn.edu.suda.bookmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "sh")
@org.hibernate.annotations.Proxy(lazy = false)
public class SH implements java.io.Serializable{
    @Id
    String id;
    String xn;
    String xq;
    String lb;
    String xy;
    boolean istj;
    boolean issh;

    public SH() {
    }

    public SH(String xn, String xq, String lb, String xy, boolean istj, boolean issh) {
        this.xn = xn;
        this.xq = xq;
        this.lb = lb;
        this.xy = xy;
        this.istj = istj;
        this.issh = issh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXn() {
        return xn;
    }

    public void setXn(String xn) {
        this.xn = xn;
    }

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }

    public String getXy() {
        return xy;
    }

    public void setXy(String xy) {
        this.xy = xy;
    }

    public boolean isIstj() {
        return istj;
    }

    public void setIstj(boolean istj) {
        this.istj = istj;
    }

    public boolean isIssh() {
        return issh;
    }

    public void setIssh(boolean issh) {
        this.issh = issh;
    }
}
