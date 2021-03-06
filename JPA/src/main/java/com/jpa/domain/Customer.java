package com.jpa.domain;

import javax.persistence.*;

/**
 * 配置映射关系
 *      实体类和表的映射关系
 *      实体类中属性和表中字段的映射关系
 *      GeneratedValue:配置主键的生成策略
 *          strategy
 *              GenerationType.IDENTITY：自增 mysql
 *                  底层数据库必须支持自动增长（底层数据库支持的自增方式对ID自增）
 *              GenerationType.SEQUENCE:序列 oracle
 *                  底层数据库必须支持序列
 *              GenerationType.TABLE：jpa提供的一种机制，通过一张数据库表的形式完成主键的自增
 *              AUTO:程序自动帮助生成主键生成策略
 */

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略
    @Column(name = "id")
    private Long id;
    @Column(name = "address")
    private  String address;
    @Column(name = "industry")
    private String industry;
    @Column(name = "level")
    private String level;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "source")
    private String source;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", industry='" + industry + '\'' +
                ", level='" + level + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
