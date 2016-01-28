package junit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itcast.crm.domain.SysUserGroup;

public class TestHibernate {
	
	@Test
	public void testHibernateConf(){
		Configuration config=new Configuration();
		config.configure();
		SessionFactory sf=config.buildSessionFactory();
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
