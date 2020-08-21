## mybatis添加操作

- 使用mysql自带UUID生成主键
```js
<insert id="addUser" parameterType="org.shihe.model.User">
    <selectKey resultType="java.lang.String" keyProperty="id" order="BEFORE">
        select uuid()
    </selectKey>
    insert into user (id,username,password) values (#{id},#{username},#{password})
</insert>
```
测试
```js
    public static void main(String[] args) throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = factory.openSession();

        User u = new User();
        u.setUsername("zhangsan");
        u.setPassword("123456");
        sqlSession.insert("org.shihe.mapper.addUser",u);
        sqlSession.commit();
        sqlSession.close();

    }
sqlSession用完后须关闭，注意SqlSession的作用域及生命周期问题，该封装不是线程安全的。使用注入框架则不用考虑作用域问题，框架本身已经做了很好的封装。
```
