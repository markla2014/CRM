package junit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.itcast.crm.Service.ISysUserGroupService;
import cn.itcast.crm.domain.SysUserGroup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpringSesssionFactory {
       @Test
       public void test(){
    	
	   ApplicationContext context=new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
	   
	   SessionFactory sf=(SessionFactory)context.getBean("sessionFactory");
	   Session s=sf.openSession();
       Transaction tx=s.beginTransaction();
       SysUserGroup sysUserGroup=new SysUserGroup();
       sysUserGroup.setName("mark");
       sysUserGroup.setPrincipal("xxx");
       sysUserGroup.setIncumbent("ttt");
       s.save(sysUserGroup);
       tx.commit();
       s.close();
       }
}
