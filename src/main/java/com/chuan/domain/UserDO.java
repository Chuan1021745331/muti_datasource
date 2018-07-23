package com.chuan.domain;


import java.math.BigDecimal;

/**
 * @类名: UserDO
 * @包名: com.example.springcloud.springcloudprovideruser.domain
 * @描述: (用一句话描述该文件做什么)
 * @日期: 2018/6/6 19:08
 */
public class UserDO {
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
