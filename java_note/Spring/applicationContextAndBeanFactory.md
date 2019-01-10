# ApplicationContext and BeanFactory

## 1. Application Context (prefer)

ApplicationContext充当了spring IOC容器的角色，ApplicationContext使用了反射的方式创建bean对象，并且在读取配置文件之后将里面注册的bean全部创建对象。我们可以通过该接口的两个实现类来创建容器：

-   ClassPathXmlApplicationContext: 如果spring的配置文件在项目的类路径下，可以使用该类创建容器
-   FileSystemXmlApplicationContext: 如果spring的配置文件不在类路径下，可以使用该来创建容器

## 2. BeanFactory

我们还可以使用BeanFactory接口充当spring IOC容器的角色，BeanFactory是ApplicationContext的父接口。与ApplicationContext不同的是BeanFactory在读取配置文件之后不会创建里面bean的对象，而是在使用的时候才会创建。

```java
@Test
public void springType2(){

    DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
    reader.loadBeanDefinitions(new FileSystemResource("F:\\monkey1024\\ssm\\learnspring\\src\\main\\resources\\applicationContext.xml"));
    //当使用该bean的时候才会创建其对象
    //StudentService studentService = (StudentService)factory.getBean("studentService");
    //studentService.study();
}
```
