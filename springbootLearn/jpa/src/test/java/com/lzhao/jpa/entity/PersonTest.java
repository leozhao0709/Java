package com.lzhao.jpa.entity;

import com.lzhao.jpa.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void insert() {
        List<Person> personList = new ArrayList<>();

        for (char i = 'a'; i <= 'z'; i++) {
            Person person = new Person();
            person.setLastName(i + "" + i);
            person.setEmail(i + "" + i + "@test.com");
            person.setBirth(LocalDate.now());
            personList.add(person);
        }
        Collections.shuffle(personList);
        personRepository.saveAll(personList);
    }

    @Test
    public void simpleQuery() {
        Person personBB = personRepository.getByLastName("bb");
        System.out.println(personBB);

        List<Person> personList1 = personRepository.getByLastNameEndingWithAndIdLessThan("a", 25);
        System.out.println(personList1);

        List<Person> personList2 = personRepository.getByEmailInAndBirthLessThan(Arrays.asList("aa@test.com", "ss@test.com"), LocalDate.of(2019, 2, 28));
        System.out.println(personList2);
    }

    @Test
    public void queryAnnotation() {
        Person maxIdPerson = personRepository.getMaxIdPerson();
        System.out.println(maxIdPerson);
    }

    @Test
    public void pagingAndSorting() {
        int page = 5 - 1; // pages start from 0, not 1
        int size = 5;

        Sort sort = Sort.by(Sort.Direction.DESC, "id")
                .and(Sort.by(Sort.Direction.ASC, "email"));

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Person> pageResult = personRepository.findAll(pageRequest);

        long totalElements = pageResult.getTotalElements(); // total elements number 
        int totalPages = pageResult.getTotalPages(); // total pages number
        int pageNumber = pageResult.getNumber() + 1; // current page number, note page start from 0 not 1
        List<Person> content = pageResult.getContent(); // current page content
        int numberOfElements = pageResult.getNumberOfElements(); // current page elements nuymber

        System.out.println("Total elements number: " + totalElements);
        System.out.println("total pages number: " + totalPages);
        System.out.println("current page number: " + pageNumber);
        System.out.println("current page content: " + content);
        System.out.println("current page elements number: " + numberOfElements);
    }

    @Test
    public void jpaSpecificationExcutor() {
        int page = 5 - 1;
        int size = 4;
        PageRequest pageRequest = PageRequest.of(page, size);

        Specification<Person> specification = (Specification<Person>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.gt(root.get("id"), 5);
        Page<Person> pageResult = personRepository.findAll(specification, pageRequest);

        long totalElements = pageResult.getTotalElements(); // total elements number
        int totalPages = pageResult.getTotalPages(); // total pages number
        int pageNumber = pageResult.getNumber() + 1; // current page number, note page start from 0 not 1
        List<Person> content = pageResult.getContent(); // current page content
        int numberOfElements = pageResult.getNumberOfElements(); // current page elements nuymber

        System.out.println("Total elements number: " + totalElements);
        System.out.println("total pages number: " + totalPages);
        System.out.println("current page number: " + pageNumber);
        System.out.println("current page content: " + content);
        System.out.println("current page elements number: " + numberOfElements);
    }
}
