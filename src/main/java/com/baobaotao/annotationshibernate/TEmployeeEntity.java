package com.baobaotao.annotationshibernate;



import javax.persistence.*;

/**
 * Author: bjccdsrlcr
 * Date: 2017/11/29 0029
 * Time: 9:38
 */
@Entity
@Table(name = "t_employee")
public class TEmployeeEntity {
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String fname;
    @Column(name = "last_name")
    private String lname;
    @Column(name = "salary")
    private int salary;

    public TEmployeeEntity(){}
    public TEmployeeEntity(String fname, String lname, int salary){
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
