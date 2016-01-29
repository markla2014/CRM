package junit;

import java.io.Serializable;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.crm.Dao.ISysUserGroupDao;
import cn.itcast.crm.domain.SysUserGroup;

public class TestSysUserGroupServiceDao {
    private static ISysUserGroupDao sysUserGroupDao;
    private static ApplicationContext context;
	@BeforeClass
	public static void init(){
		 context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 sysUserGroupDao = (ISysUserGroupDao) context.getBean(ISysUserGroupDao.SERVICE_NAME);   
}
	@Test
	public void testDelete(){
	    Serializable[] ids={1}; 
	    sysUserGroupDao.deleteByIds(ids);
	}
	@Test
	public void testGetUsers(){
		sysUserGroupDao.findObjectsByConditionWithNoPage().forEach(a->System.out.println(a.getId()));
	}
}
