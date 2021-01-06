# Junit 5

官网： https://junit.org/junit5/

### 基本要求
- JDK1.8+

### maven引用
```
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.junit</groupId>
            <artifactId>junit-bom</artifactId>
            <version>5.7.0</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>

<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.7.0</version>
</dependency>
```

### 关于Junit5 

Junit 5 = JUnit Platform  + JUnit Jupiter + JUnit Vintage

#### JUnit Platform  
JUint平台是基于JVM的测试框架，我们可以使用TestEngine API，开发一个测试框架运行在这个平台上。  
平台也提供了Console Launcher的方式通过控制台命令行来执行基于Junit 4的测试

#### JUnit Jupiter
这是JUnit的编程模型和扩展模型的组合，我们可以在这个模型下编写自己的测试用例。

#### JUnit Vintage
为JUnit 3和JUnit 提供了TestEngine。

### 关于JUnit 5的注解
#### @Test
定义个测试方法

#### @DisplayName
测试结果中，类或方法显示的名称。

#### @Disabled
禁用某个测试方法（参数支持用例打印信息）



### Assumption的概念
假设条件，如果假设条件不成立，测试会被忽略。

### 例子
入门用例: JUnit5HelloWorld.java