package com.lzhao.jpa.repository;

import com.lzhao.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {

    Person getByLastName(String name);

    //WHERE lastName LIKE ?% AND id < ?
    List<Person> getByLastNameStartingWithAndIdLessThan(String lastName, int id);

    //WHERE lastName LIKE %? AND id < ?
    List<Person> getByLastNameEndingWithAndIdLessThan(String lastName, int id);

    //WHERE email IN (?, ?, ?) OR birth < ?
    List<Person> getByEmailInAndBirthLessThan(List<String> emails, LocalDate birth);

    @Query("select p from Person p where p.id = (select max(p2.id) from Person p2)")
    Person getMaxIdPerson();

	@Query("SELECT p FROM Person p WHERE p.lastName = ?1 AND p.email = ?2")
	List<Person> testQueryAnnotationParams1(String lastName, String email);

	@Query("SELECT p FROM Person p WHERE p.lastName = :lastName AND p.email = :email")
	List<Person> testQueryAnnotationParams2(@Param("email") String email, @Param("lastName") String lastName);

	@Query("SELECT p FROM Person p WHERE p.lastName LIKE %?1% OR p.email LIKE %?2%")
	List<Person> testQueryAnnotationLikeParam(String lastName, String email);

	@Query("SELECT p FROM Person p WHERE p.lastName LIKE %:lastName% OR p.email LIKE %:email%")
	List<Person> testQueryAnnotationLikeParam2(@Param("email") String email, @Param("lastName") String lastName);

	@Query(value="SELECT count(id) FROM jpa_persons", nativeQuery=true)
	long getTotalCount();
}
