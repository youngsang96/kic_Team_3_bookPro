package util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnection {
    private static  SqlSessionFactory sqlmap;
	 static {
//		SqlSessionFactory  sqlMap = null;
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mapperXML/mybatis-config.xml");
			sqlmap = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("ok config");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		}	}
	 public static SqlSession getConnection() {
		 return sqlmap.openSession();	 }
	 
	 public static void close(SqlSession session) {
		 session.commit();		 session.close();	 }

}
