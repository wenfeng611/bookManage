package cn.edu.suda.bookmanagement.dto;

import java.io.Serializable;

public class TeachTaskSearchBean implements Serializable{
    String kcdm;
    String kcmc;
    String xf;
    String kkxy;

    public TeachTaskSearchBean(String kcdm, String kcmc, String xf, String kkxy) {
        this.kcdm = kcdm;
        this.kcmc = kcmc;
        this.xf = xf;
        this.kkxy = kkxy;
    }

    public TeachTaskSearchBean() {
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
}
