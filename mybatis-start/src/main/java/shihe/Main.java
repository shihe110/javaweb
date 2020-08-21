package shihe;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import shihe.model.User;

import java.io.IOException;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-08-21 10:16
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = factory.openSession();
        User o = sqlSession.selectOne("shihe.mapper.getUserById",5L);
        System.out.println(o.toString()+"====================");

    }
}
