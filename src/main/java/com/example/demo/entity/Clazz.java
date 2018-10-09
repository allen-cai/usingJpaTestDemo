package com.example.demo.entity;


import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;

/**
 * 作者 : caiLun
 * 时间 : 2018/10/8
 */
@Entity
@Table(name = "c_clazz", schema = "test")
public class Clazz {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "class_num")
    private Long classNum;

    @OneToMany(mappedBy = "clazz", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<UserEntity> userEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getClassNum() {
        return classNum;
    }

    public void setClassNum(Long classNum) {
        this.classNum = classNum;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", classNum=" + classNum;
    }
}
