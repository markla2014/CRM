package junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.crm.Service.ISysUserGroupService;
import cn.itcast.crm.domain.SysUserGroup;

public class TestServiceLevel {

	 private static ISysUserGroupService sysUserGroupService;
	    private static ApplicationContext context;
		@BeforeClass
		public static void init(){
			 context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
			 sysUserGroupService = (ISysUserGroupService) context.getBean(ISysUserGroupService.SERVICE_NAME);   
	}
		@Test
		public void testSave(){
			SysUserGroup sysUserGroup = new SysUserGroup();
			sysUserGroup.setName("销售部");
			sysUserGroup.setPrincipal("xxx");
			sysUserGroup.setIncumbent("ttt");
			sysUserGroupService.saveSysUserGroup(sysUserGroup);
		}
}
