package com.lzhao.girlservice.services;

import com.lzhao.girlservice.entity.Girl;
import com.lzhao.girlservice.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public Optional<Girl> findOne(int id) {

        return girlRepository.findById(id);
    }
}
