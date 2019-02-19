package com.lzhao.girlservice.repository;

import com.lzhao.girlservice.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    List<Girl> findGirlsByAge(int age);
}
