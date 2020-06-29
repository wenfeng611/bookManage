package cn.edu.suda.bookmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@org.hibernate.annotations.Proxy(lazy = false)
public class User implements java.io.Serializable{
    @Id
    String id;
    String username;
    String password;
    String professional;
    String academic;
    String type;
    String job_number;
    String name;

    public User() {
    }

    public User(String id, String username, String password, String professional, String academic, String type, String job_number, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.professional = professional;
        this.academic = academic;
        this.type = type;
        this.job_number = job_number;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getAcademic() {
        return academic;
    }

    public void setAcademic(String academic) {
        this.academic = academic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJob_number() {
        return job_number;
    }

    public void setJob_number(String job_number) {
        this.job_number = job_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
