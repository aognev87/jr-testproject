package ru.aognev.jrtestproject.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    private int userId;
    private String name;
    private int age;
    private int isAdmin = 0;
    private String createdDate;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public User() {
        createdDate = simpleDateFormat.format(new Date());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getUserId() {
        return userId;
    }

    @Column
    public String getName() {
        return name;
    }

    @Column
    public int getAge() {
        return age;
    }

    @Column
    public int getIsAdmin() {
        return isAdmin;
    }

    @Column
    public String getCreatedDate() {
        return createdDate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (isAdmin != user.isAdmin) return false;
        if (userId != user.userId) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (createdDate != null ? !createdDate.equals(user.createdDate) : user.createdDate != null) return false;
        return simpleDateFormat != null ? simpleDateFormat.equals(user.simpleDateFormat) : user.simpleDateFormat == null;

    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + isAdmin;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (simpleDateFormat != null ? simpleDateFormat.hashCode() : 0);
        return result;
    }
}
