package com.jiangli.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
@SuppressWarnings("unchecked")
public class StudentDao extends SqlMapClientDaoSupport {  
	  
    public List<Student> findAllStudent() throws SQLException {  
        List<Student> result = getSqlMapClient().queryForList("findAllStudent"); 
        for(int i=0;i<result.size();i++){
        	System.out.println(result.get(i).tostring());
        }
          
        return result;  
    }  
    
    public static void main(String[] args) throws Exception {  
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");  
        StudentDao studentDao = (StudentDao) applicationContext.getBean("StudentDao");  
        studentDao.findAllStudent();  
    } 
}
