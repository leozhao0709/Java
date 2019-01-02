# Mapper 动态代理

## 1. usage

We **don't need to write the DAO impl class** and mapper dynamic proxy can help you do this boring stuff.

## 2. how to use it

1.  In you `mapper.xml`, update namespace to corresponding DAO interface.
2.  In you DAO interface, method name should match the id in your `mapper.xml`
3.  You can get the `DAO` and `SqlSession` like this:

    ```java
    public class StudentDaoTest {

        private SqlSession sqlSession;
        private StudentDao studentDao;

        @Before
        public void setUp() throws Exception {
            sqlSession = MyBatisUtil.getSqlSession();
            studentDao = sqlSession.getMapper(StudentDao.class);
        }

        @After
        public void tearDown() throws Exception {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        @Test
        public void insertStudent() {
            Student student = new Student("刘德华", 52, 98.50);
            this.studentDao.insertStudent(student);
            System.out.println(student);
        }

        @Test
        public void deleteStudent() {
            this.studentDao.deleteStudent(11);
        }

        @Test
        public void updateStudent() {
            Student s = new Student(2, "郭富城", 50, 96.5);
            this.studentDao.updateStudent(s);
        }

        @Test
        public void selectAllStudents() {
            List<Student> allStudents = this.studentDao.selectAllStudents();
            allStudents.forEach(System.out::println);
        }

        @Test
        public void selectStudentById() {
            Student student = this.studentDao.selectStudentById(2);
            System.out.println(student);
        }

        @Test
        public void selectStudentByName() {
            List<Student> students = this.studentDao.selectStudentByNameLike("郭");
            students.forEach(System.out::println);
        }
    }
    ```
