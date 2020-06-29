package cn.edu.suda.bookmanagement.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@org.hibernate.annotations.Proxy(lazy = false)
public class Student implements java.io.Serializable{
    @Id
    String id;
    String name;
    String gener;
    String xzb;
    String Professionalid;
    String academic;

    public Student() {
    }

    public Student(String id, String name, String gener, String xzb, String professionalid, String academic) {
        this.id = id;
        this.name = name;
        this.gener = gener;
        this.xzb = xzb;
        Professionalid = professionalid;
        this.academic = academic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public String getXzb() {
        return xzb;
    }

    public void setXzb(String xzb) {
        this.xzb = xzb;
    }

    public String getProfessionalid() {
        return Professionalid;
    }

    public void setProfessionalid(String professionalid) {
        Professionalid = professionalid;
    }

    public String getAcademic() {
        return academic;
    }

    public void setAcademic(String academic) {
        this.academic = academic;
    }
}
