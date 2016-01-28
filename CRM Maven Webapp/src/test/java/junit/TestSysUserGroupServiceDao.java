package junit;

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
	public void testSave() {
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup.setName("销售部");
		sysUserGroup.setPrincipal("xxx");
		sysUserGroup.setIncumbent("ttt");
	}
	@Test
	public void testUpdate() {
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup.setId(1);
		sysUserGroup.setName("销售部01");
		sysUserGroup.setPrincipal("tom");
		sysUserGroup.setIncumbent("销售部");
		sysUserGroupDao.update(sysUserGroup);
	}
	
}
