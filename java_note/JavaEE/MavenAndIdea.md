# Using Maven and Idea to create a Java EE

## 1. create project

-   Open IntelliJ and select create maven project.
-   Select Project SDK and then check `create from archetype` and select `maven-archetype-webapp`. Note there are 2 webapp, you should select this one.
-   input GroupId and ArtifactId and continue.
-   After maven build first time, there are `src` folder. You need manually create `src/main/java` and `src/main/resources` folder. And you need to mark these folders as `source root` and `resources`.
-   Another thing you need to notice is **default** `src/main/webapp/WEB-INF/web.xml` is **2.3 version**. You may want a new version of this file: open `Project structure`, shortcut: `command + ;`, select `Facets` and select your module. 
-   Then first delete the old deployment Descriptors (click `-` button) and **click apply**, then add a new one (click `+` button) and **click apply** button. **Note if you create a module, then you need to edit the correct path for your `web.xml` when you edit it in old intelliJ.**
-   In `pom.xml`, you may want to modify java version in `properties` tag.