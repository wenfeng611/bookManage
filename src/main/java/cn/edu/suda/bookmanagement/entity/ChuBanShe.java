package cn.edu.suda.bookmanagement.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chubanshe")
@org.hibernate.annotations.Proxy(lazy = false)
public class ChuBanShe implements java.io.Serializable{
    @Id
    String cbsmc;
    String pinyin;
    String cbsjc;

    public ChuBanShe() {
    }

    public ChuBanShe(String cbsmc, String pinyin, String cbsjc) {
        this.cbsmc = cbsmc;
        this.pinyin = pinyin;
        this.cbsjc = cbsjc;
    }

    public String getCbsmc() {
        return cbsmc;
    }

    public void setCbsmc(String cbsmc) {
        this.cbsmc = cbsmc;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getCbsjc() {
        return cbsjc;
    }

    public void setCbsjc(String cbsjc) {
        this.cbsjc = cbsjc;
    }
}
