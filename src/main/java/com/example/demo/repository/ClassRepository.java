package com.example.demo.repository;

import com.example.demo.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 作者 : caiLun
 * 时间 : 2018/10/9
 */
public interface ClassRepository extends JpaRepository<Clazz, Long>, BaseRepository<Clazz, Long> {

}
