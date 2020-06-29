package cn.edu.suda.bookmanagement.entity;

import javax.persistence.*;


@Entity
@Table(name = "coursejc")
@org.hibernate.annotations.Proxy(lazy = false)
public class CourseJC {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    String sxh;
    String kcdm;
    String kcmc;
    String yxj;
    String fzh;
    String bz;
    String kcpy;
    String jcsxh; //教材顺序号

    public CourseJC() {
    }

    public CourseJC(String kcdm, String kcmc, String yxj, String fzh, String bz, String kcpy, String jcsxh) {
        this.kcdm = kcdm;
        this.kcmc = kcmc;
        this.yxj = yxj;
        this.fzh = fzh;
        this.bz = bz;
        this.kcpy = kcpy;
        this.jcsxh = jcsxh;
    }

    public String getSxh() {
        return sxh;
    }

    public void setSxh(String sxh) {
        this.sxh = sxh;
    }

    public String getKcdm() {
        return kcdm;
    }

    public void setKcdm(String kcdm) {
        this.kcdm = kcdm;
    }

    public String getKcmc() {
        return kcmc;
    }

    public void setKcmc(String kcmc) {
        this.kcmc = kcmc;
    }

    public String getYxj() {
        return yxj;
    }

    public void setYxj(String yxj) {
        this.yxj = yxj;
    }

    public String getFzh() {
        return fzh;
    }

    public void setFzh(String fzh) {
        this.fzh = fzh;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getKcpy() {
        return kcpy;
    }

    public void setKcpy(String kcpy) {
        this.kcpy = kcpy;
    }

    public String getJcsxh() {
        return jcsxh;
    }

    public void setJcsxh(String jcsxh) {
        this.jcsxh = jcsxh;
    }
}
