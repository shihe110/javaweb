## mybatis之hello world

- 1.新建maven项目

- 2.添加maven依赖
```js
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.21</version>
</dependency>
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.5</version>
</dependency>
```
- 3.编写测试代码

- 4.启动测试结果
```js
    public static void main(String[] args) throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = factory.openSession();
        User o = sqlSession.selectOne("org.shihe.mapper.getUserById",5L);
        System.out.println(o.toString()+"====================");

    }

// 一个mybatis应用的核心实例是一个SqlSessionFactory，该工厂类提供SqlSession，该接口封装的对数据库的增删改查操作。
```

注：mybatis的配置文件mybatis-config.xml
```js
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/security?serverTimezone=Asia/Shanghai"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="mapper/UserMapper.xml"/>
    </mappers>
</configuration>
```
该配置文件对应mybatis配置类：Configuration
包含environments  mappers等
environments又可设置多个环境信息，包括事务管理器、数据源信息等
mappers定义的映射文件路径




