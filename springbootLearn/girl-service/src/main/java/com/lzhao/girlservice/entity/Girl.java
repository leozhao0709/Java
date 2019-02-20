package com.lzhao.girlservice.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "girl")
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "字段必传")
    private String cupSize;

    @Min(value = 18, message = "未成年禁止入内")
    private int age;

    @NotNull(message = "金额必传")
    private Double money;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "insertDate")
    private LocalDate addDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int password;

    @Transient
    @JsonIgnore
    private String info;



    public Girl() {
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", addDate=" + addDate
                ;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getInfo() {
        return info;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
