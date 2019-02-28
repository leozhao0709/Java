# Repository

## 0. cerate entity

```java
@Entity
@Table(name = "JPA_PERSONS")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private LocalDate birth;

    public Person() {
    }
}
```

## 1. simple query

```java
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person getByLastName(String name);

    //WHERE lastName LIKE ?% AND id < ?
    List<Person> getByLastNameStartingWithAndIdLessThan(String lastName, int id);

    //WHERE lastName LIKE %? AND id < ?
    List<Person> getByLastNameEndingWithAndIdLessThan(String lastName, int id);

    //WHERE email IN (?, ?, ?) OR birth < ?
    List<Person> getByEmailInAndBirthLessThan(List<String> emails, LocalDate birth);
}
```

Note:

- Simple query should start with `getBy`, `findBy` or `readBy`.
- keyword table

  | Keyword      | Sample                                 | JPQL snippet                                                 |
  | ------------ | -------------------------------------  | ------------------------------------------------------------ |
  | And          | `findByLastnameAndFirstname`           | …where x.lastname = ?1 and x.firstname = ?2                  |
  | Or           | `findByLastnameOrFirstname`            | …where x.lastname = ?1 or x.firstname = ?2                   |
  | Not          | `findByLastnameNot`                    | …where x.lastname <> ?1                                      |
  | LessThan     | `findByAgeLessThan`                    | …where x.age < ?1                                            |
  | greaterThan  | `findByAgeGreaterThan`                 | …where x.age > ?1                                            |
  | Between      | `findByStartDateBetween`               | …where x.startDate between ?1 and ?2                         |
  | After        | `findByStartDateAfter`                 | …where x.startDate > ?1                                      |
  | Before       | `findByStartDateBefore`                | …where x.startDate < ?1                                      |
  | IsNull       | `findByAgeIsNull`                      | …where x.age is null                                         |
  | (Is)NotNull  | `findByAge(Is)NotNull  `               | …where x.age is not null                                     |
  | Like         | `findByFirstnameLike`                  | …where x.firstname like ?1                                   |
  | NotLike      | `findByFirstnameNotLike`               | …where x.firstname not like ?1                               |
  | StartingWith | `findByFirstnameStartingWith`          | …where x.firstname like ?1 (parameter bound with appended %) |
  | EndingWith   | `findByFirstnameEndingWith`            | …where x.firstname like ?1 (parameter bound with prepended %) |
  | Containing   | `findByFirstnameContaining`            | …where x.firstname like ?1 (parameter bound wrapped in %)    |
  | OrderBy      | `findByAgeOrderByLastnameDesc`         | …where x.age = ?1 order by x.lastname desc                   |
  | In           | `findByAgeIn(Collection<Age> ages) `   | …where x.age in ?1                                           |
  | NotIn        | `findByAgeNotIn(Collection<Age> ages)` | …where x.age not in ?1                                       |
  | TRUE         | `findByActiveTrue()`                   | …where x.active = true                                       |
  | FALSE        | `findByActiveFalse()`                  | …where x.active = false                                      |


## 2. `@Query`

```java
public interface PersonRepository extends JpaRepository<Person, Integer> {

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

    @Modifying
	@Query("UPDATE Person p SET p.email = :email WHERE id = :id")
	void updatePersonEmail(@Param("id") Integer id, @Param("email") String email);
}
```

Note:

-   You can use something like `?1` `?2` to do a placeholder.
-   You can also use `:lastName` `:email` to do a placeholder. When you have many parameters, recommend this one.
-   In `@Query`, we can use `%` in like query.
-   We can also use `nativeQuery` with the second params `nativeQuery=true`
-   **We need to use `@Modifying` to do an update query.** Meanwhile, for update query, you also need **transaction**. You always add transaction in your service level.

## 3. paging and sorting

```java
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
}
```

Note:

-   **pages start from 0, not 1**


## 4. SpecificationExecutor

```java
public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {

}
```

```java
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
```

Note:

-   Your repository should extends `JpaSpecificationExecutor<T>`.
-   you can define `Specification` with lambda expression.
-   For `Specification`, `root` is the object which you want to look through. `criteriaBuilder` is the criteria factory class which you can use to create criteria.
