package com.example.demo.controller;

import com.example.demo.entity.Clazz;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * 作者 : caiLun
 * 时间 : 2018/10/9
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    void getMessage(@RequestParam(name = "className") String className,@RequestParam(name = "userName") String userName) {

        System.out.println("**********" + className + "*************" + userName);
        List<UserEntity> userEntities = userEntityRepository.findAll(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate classNameLike = null, userNameLike = null;

                userNameLike = criteriaBuilder.like(root.<String>get("username"), "%" + userName + "%");
                classNameLike = criteriaBuilder.like(root.<String>get("clazz").<String>get("className") , "%" + className + "%");

                criteriaQuery.where(userNameLike, classNameLike);
                return null;
            }

        });


        System.out.println("**************************测试**************************");
        if (!userEntities.isEmpty()) {
            for (UserEntity userEntity : userEntities) {
                System.out.println("+++++++++++++++++++++++++name" + userEntity.getUsername());
                System.out.println("班级名"  + userEntity.getClazz().getClassName());
            }
        }
    }


}
