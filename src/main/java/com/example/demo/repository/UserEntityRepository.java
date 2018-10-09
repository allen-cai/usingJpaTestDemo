package com.example.demo.repository;

import com.example.demo.entity.Clazz;
import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 作者 : caiLun
 * 时间 : 2018/10/9
 */
public interface UserEntityRepository extends JpaRepository<UserEntity, Long>, BaseRepository<UserEntity, Long> {

}
