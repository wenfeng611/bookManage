package cn.edu.suda.bookmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "jc")
@org.hibernate.annotations.Proxy(lazy = false)
public class JC implements java.io.Serializable{
         @Id
         @GeneratedValue(strategy= GenerationType.AUTO)
         String sxh;

        String jcmc;
        String jczz;
        String bbh;
        String cbs;
        String price;
        String kcsl;
        String yxjc;
        String jcbh;
        String bzsh;
        String cbdate;
        String syzy;
        String sydx;
        String jclx;
        String sjh;
        String zk;
        String gys;
        String ykcsl;
        String jcghjbmc;
        String jchjqkmc;
        String sfxbh;
        String cbj;
        String jctxm;
        String kkbm;
        String jczs;
        String jcys;
        String kcmc;
        String cbjhj;
        String sfxs;
        String sfzf;
        String mrzk;
        String pinyin;
        String shzt;
        String srr;
        String srrq;
        String cbny;
        String ghmc;
        String hjmc;
        String zddw;
        String tjdw;

    public JC() {
    }

    public JC(String sxh, String jcmc, String jczz, String bbh, String cbs, String price, String kcsl, String yxjc, String jcbh, String bzsh, String cbdate, String syzy, String sydx, String jclx, String sjh, String zk, String gys, String ykcsl, String jcghjbmc, String jchjqkmc, String sfxbh, String cbj, String jctxm, String kkbm, String jczs, String jcys, String kcmc, String cbjhj, String sfxs, String sfzf, String mrzk, String pinyin, String shzt, String srr, String srrq, String cbny, String ghmc, String hjmc, String zddw, String tjdw) {
        this.sxh = sxh;
        this.jcmc = jcmc;
        this.jczz = jczz;
        this.bbh = bbh;
        this.cbs = cbs;
        this.price = price;
        this.kcsl = kcsl;
        this.yxjc = yxjc;
        this.jcbh = jcbh;
        this.bzsh = bzsh;
        this.cbdate = cbdate;
        this.syzy = syzy;
        this.sydx = sydx;
        this.jclx = jclx;
        this.sjh = sjh;
        this.zk = zk;
        this.gys = gys;
        this.ykcsl = ykcsl;
        this.jcghjbmc = jcghjbmc;
        this.jchjqkmc = jchjqkmc;
        this.sfxbh = sfxbh;
        this.cbj = cbj;
        this.jctxm = jctxm;
        this.kkbm = kkbm;
        this.jczs = jczs;
        this.jcys = jcys;
        this.kcmc = kcmc;
        this.cbjhj = cbjhj;
        this.sfxs = sfxs;
        this.sfzf = sfzf;
        this.mrzk = mrzk;
        this.pinyin = pinyin;
        this.shzt = shzt;
        this.srr = srr;
        this.srrq = srrq;
        this.cbny = cbny;
        this.ghmc = ghmc;
        this.hjmc = hjmc;
        this.zddw = zddw;
        this.tjdw = tjdw;
    }

    public String getSxh() {
        return sxh;
    }

    public void setSxh(String sxh) {
        this.sxh = sxh;
    }

    public String getJcmc() {
        return jcmc;
    }

    public void setJcmc(String jcmc) {
        this.jcmc = jcmc;
    }

    public String getJczz() {
        return jczz;
    }

    public void setJczz(String jczz) {
        this.jczz = jczz;
    }

    public String getBbh() {
        return bbh;
    }

    public void setBbh(String bbh) {
        this.bbh = bbh;
    }

    public String getCbs() {
        return cbs;
    }

    public void setCbs(String cbs) {
        this.cbs = cbs;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getKcsl() {
        return kcsl;
    }

    public void setKcsl(String kcsl) {
        this.kcsl = kcsl;
    }

    public String getYxjc() {
        return yxjc;
    }

    public void setYxjc(String yxjc) {
        this.yxjc = yxjc;
    }

    public String getJcbh() {
        return jcbh;
    }

    public void setJcbh(String jcbh) {
        this.jcbh = jcbh;
    }

    public String getBzsh() {
        return bzsh;
    }

    public void setBzsh(String bzsh) {
        this.bzsh = bzsh;
    }

    public String getCbdate() {
        return cbdate;
    }

    public void setCbdate(String cbdate) {
        this.cbdate = cbdate;
    }

    public String getSyzy() {
        return syzy;
    }

    public void setSyzy(String syzy) {
        this.syzy = syzy;
    }

    public String getSydx() {
        return sydx;
    }

    public void setSydx(String sydx) {
        this.sydx = sydx;
    }

    public String getJclx() {
        return jclx;
    }

    public void setJclx(String jclx) {
        this.jclx = jclx;
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh;
    }

    public String getZk() {
        return zk;
    }

    public void setZk(String zk) {
        this.zk = zk;
    }

    public String getGys() {
        return gys;
    }

    public void setGys(String gys) {
        this.gys = gys;
    }

    public String getYkcsl() {
        return ykcsl;
    }

    public void setYkcsl(String ykcsl) {
        this.ykcsl = ykcsl;
    }

    public String getJcghjbmc() {
        return jcghjbmc;
    }

    public void setJcghjbmc(String jcghjbmc) {
        this.jcghjbmc = jcghjbmc;
    }

    public String getJchjqkmc() {
        return jchjqkmc;
    }

    public void setJchjqkmc(String jchjqkmc) {
        this.jchjqkmc = jchjqkmc;
    }

    public String getSfxbh() {
        return sfxbh;
    }

    public void setSfxbh(String sfxbh) {
        this.sfxbh = sfxbh;
    }

    public String getCbj() {
        return cbj;
    }

    public void setCbj(String cbj) {
        this.cbj = cbj;
    }

    public String getJctxm() {
        return jctxm;
    }

    public void setJctxm(String jctxm) {
        this.jctxm = jctxm;
    }

    public String getKkbm() {
        return kkbm;
    }

    public void setKkbm(String kkbm) {
        this.kkbm = kkbm;
    }

    public String getJczs() {
        return jczs;
    }

    public void setJczs(String jczs) {
        this.jczs = jczs;
    }

    public String getJcys() {
        return jcys;
    }

    public void setJcys(String jcys) {
        this.jcys = jcys;
    }

    public String getKcmc() {
        return kcmc;
    }

    public void setKcmc(String kcmc) {
        this.kcmc = kcmc;
    }

    public String getCbjhj() {
        return cbjhj;
    }

    public void setCbjhj(String cbjhj) {
        this.cbjhj = cbjhj;
    }

    public String getSfxs() {
        return sfxs;
    }

    public void setSfxs(String sfxs) {
        this.sfxs = sfxs;
    }

    public String getSfzf() {
        return sfzf;
    }

    public void setSfzf(String sfzf) {
        this.sfzf = sfzf;
    }

    public String getMrzk() {
        return mrzk;
    }

    public void setMrzk(String mrzk) {
        this.mrzk = mrzk;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getShzt() {
        return shzt;
    }

    public void setShzt(String shzt) {
        this.shzt = shzt;
    }

    public String getSrr() {
        return srr;
    }

    public void setSrr(String srr) {
        this.srr = srr;
    }

    public String getSrrq() {
        return srrq;
    }

    public void setSrrq(String srrq) {
        this.srrq = srrq;
    }

    public String getCbny() {
        return cbny;
    }

    public void setCbny(String cbny) {
        this.cbny = cbny;
    }

    public String getGhmc() {
        return ghmc;
    }

    public void setGhmc(String ghmc) {
        this.ghmc = ghmc;
    }

    public String getHjmc() {
        return hjmc;
    }

    public void setHjmc(String hjmc) {
        this.hjmc = hjmc;
    }

    public String getZddw() {
        return zddw;
    }

    public void setZddw(String zddw) {
        this.zddw = zddw;
    }

    public String getTjdw() {
        return tjdw;
    }

    public void setTjdw(String tjdw) {
        this.tjdw = tjdw;
    }
}
