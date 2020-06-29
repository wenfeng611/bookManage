package cn.edu.suda.bookmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "teachtask")
@org.hibernate.annotations.Proxy(lazy = false)
public class TeachTask implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    String id;
    String xn;
    String xq;
    String xkkh;
    String bjjc;
    String kcdm;
    String kcmc;
    String prnkcmc;
    String xf;
    String kkxy;
    String jsxm;
    String kcxz;
    String skdd;
    String sksj;
    String lb;
    String xqyq;
    String sh;
    String tp;
    String needcaculatejc;

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

    public String getXkkh() {
        return xkkh;
    }

    public void setXkkh(String xkkh) {
        this.xkkh = xkkh;
    }

    public String getBjjc() {
        return bjjc;
    }

    public void setBjjc(String bjjc) {
        this.bjjc = bjjc;
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

    public String getPrnkcmc() {
        return prnkcmc;
    }

    public void setPrnkcmc(String prnkcmc) {
        this.prnkcmc = prnkcmc;
    }

    public String getXf() {
        return xf;
    }

    public void setXf(String xf) {
        this.xf = xf;
    }

    public String getKkxy() {
        return kkxy;
    }

    public void setKkxy(String kkxy) {
        this.kkxy = kkxy;
    }

    public String getJsxm() {
        return jsxm;
    }

    public void setJsxm(String jsxm) {
        this.jsxm = jsxm;
    }

    public String getKcxz() {
        return kcxz;
    }

    public void setKcxz(String kcxz) {
        this.kcxz = kcxz;
    }

    public String getSkdd() {
        return skdd;
    }

    public void setSkdd(String skdd) {
        this.skdd = skdd;
    }

    public String getSksj() {
        return sksj;
    }

    public void setSksj(String sksj) {
        this.sksj = sksj;
    }

    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }

    public String getXqyq() {
        return xqyq;
    }

    public void setXqyq(String xqyq) {
        this.xqyq = xqyq;
    }

    public String getSh() {
        return sh;
    }

    public void setSh(String sh) {
        this.sh = sh;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getNeedcaculatejc() {
        return needcaculatejc;
    }

    public void setNeedcaculatejc(String needcaculatejc) {
        this.needcaculatejc = needcaculatejc;
    }

    public TeachTask() {
    }

    public TeachTask(String xn, String xq, String xkkh, String bjjc, String kcdm, String kcmc, String prnkcmc, String xf, String kkxy, String jsxm, String kcxz, String skdd, String sksj, String lb, String xqyq, String sh, String tp, String needcaculatejc) {
        this.xn = xn;
        this.xq = xq;
        this.xkkh = xkkh;
        this.bjjc = bjjc;
        this.kcdm = kcdm;
        this.kcmc = kcmc;
        this.prnkcmc = prnkcmc;
        this.xf = xf;
        this.kkxy = kkxy;
        this.jsxm = jsxm;
        this.kcxz = kcxz;
        this.skdd = skdd;
        this.sksj = sksj;
        this.lb = lb;
        this.xqyq = xqyq;
        this.sh = sh;
        this.tp = tp;
        this.needcaculatejc = needcaculatejc;
    }
}
