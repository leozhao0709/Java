package com.lzhao.jpa.repository;

import com.lzhao.jpa.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
