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
@Table(name = "cst_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custID;
    @Column(name = "cust_name")
    private String custName;
    @Column(name = "cust_source")
    private String custSource;
    @Column(name = "cust_level")
    private String custLevel;
    @Column(name = "cust_industry")
    private String custIndustry;
    @Column(name = "cust_phone")
    private String custPhone;
    @Column(name = "cust_address")
    private String custAddress;

    public Long getCustID() {
        return custID;
    }

    public void setCustID(Long custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custID='" + custID + '\'' +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custAddress='" + custAddress + '\'' +
                '}';
    }
}
