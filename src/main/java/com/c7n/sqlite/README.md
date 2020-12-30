# SQLite

官方网站： https://www.sqlite.org/index.html  


### Maven依赖
```xml
<!-- Sqlite-jdbc -->
<dependency>
    <groupId>com.github.gwenn</groupId>
    <artifactId>sqlite-dialect</artifactId>
    <version>0.1.0</version>
</dependency>
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.21.0.1</version>
</dependency>
```

### yml配置
```yaml
spring:
  datasource:
    url: jdbc:sqlite:./db/example.db
    username:
    password:
    driver-class-name: org.sqlite.JDBC
    jpa:
      database: org.hibernate.dialect.SQLiteDialect
      database-platform: org.hibernate.dialect.SQLiteDialect
      show-sql: true
      open-in-view: true
      hibernate:
        ddl-auto: update
```

## 问题集
#### [SQLITE_ERROR] SQL error or missing database (no such table: hibernate_sequence)
JPA如果strategy = GenerationType.SEQUENCE 会自动创建hibernate_sequence表。  
因此需要将strategy改为GenerationType.IDENTITY即可。  
如果必须使用SEQUENCE则在测试之前 手动创建table。

