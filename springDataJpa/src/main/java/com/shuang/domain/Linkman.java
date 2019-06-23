package com.shuang.domain;

import javax.persistence.*;

@Entity
@Table(name = "linkman")
public class Linkman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="gender")
    private String gender;
    @Column(name="phone")
    private String phone;
    @Column(name="mobile")
    private String mobile;
    @Column(name="email")
    private String email;
    @Column(name="position")
    private String position;
    @Column(name="memo")
    private String memo;

    /**
     * 配置多对一的关系
     *      使用注解的方式配置多对一关系
     *          manyToOne:配置多对一的关系
     *              targetEntity：对方的实体类字节码
     *      配置表关系
     *      配置外键
     *      配置外键配置到了多的一方，就会在多的一方维护外键
     */
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "lkmId",referencedColumnName = "id")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Linkman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
