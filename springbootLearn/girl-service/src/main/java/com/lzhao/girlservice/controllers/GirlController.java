package com.lzhao.girlservice.controllers;

import com.lzhao.girlservice.entity.Girl;
import com.lzhao.girlservice.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping("/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    @PostMapping("/girl/add")
    public Girl addGirl(@Valid @RequestBody Girl girl, BindingResult bindingResult) {
        System.out.println("girl..." + girl);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        if (girl.getAddDate() == null) {
            girl.setAddDate(LocalDate.now());
        }
        return girlRepository.save(girl);
    }
}
