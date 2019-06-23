package com.shuang.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
* 配置实体类和表的映射关系
* 类中属性和表的映射关系
* */
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
    /**
     * 配置多表之间的映射关系
     * 使用注解的形式进行配置
     *  oneToMany:配置一对多的关系
     *  targetEntity对方对象的字节码
     *  配置外键（中间表）
     *      joinColumn：配置外键
     *      name:外键字段名称
     *      referencedColumnName：参照的主表的主键字段名
     *
     * 在一的一方添加了外键配置，所以对于一的一方，也具备了维护外键的作用
      */
    /*@OneToMany(targetEntity = Linkman.class)
    @JoinColumn(name = "custId",referencedColumnName = "id")*/
    /**
     * cascade = CascadeType.ALL:所有
     * merge:更新
     * remove：删除
     * persist：保存
     * fetch:配置关联对象的加载方式
     *      eager：立即加载
     *      lazy：延迟加载
     */
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)//放弃维护权，取值对方配置关系的属性名称
    private Set<Linkman> linkmens = new HashSet<Linkman>();

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

    public Set<Linkman> getLinkmens() {
        return linkmens;
    }

    public void setLinkmens(Set<Linkman> linkmens) {
        this.linkmens = linkmens;
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
