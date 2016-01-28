package cn.itcast.crm.Dao.Impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.crm.Dao.ICommonDao;
//import cn.itcast.crm.domain.SysPopedomPrivilege;
import cn.itcast.crm.Util.GenericClass;

@SuppressWarnings("unchecked")
public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T> {
	private Class entityClass=GenericClass.getGenericClass(this.getClass());
   public CommonDaoImpl() {
   
}
	@Resource(name="sessionFactory")
	public  void setSessionFactoryDI(SessionFactory sessionFactory) {
	    //调用父类的setSessionFactory方法,注入sessionFactory
		super.setSessionFactory(sessionFactory);
	}
	public void save(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(entity);
	}

	public void update(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(entity);
	}

	public T findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		if(id==null){
			throw new RuntimeException("您要查找的["+id+"]不能为空");
		}
		return (T)this.getHibernateTemplate().get(entityClass, id);
	}

	public void deleteByIds(Serializable... ids) {
		// TODO Auto-generated method stub
		if(ids!=null&&ids.length>0){
			for(Serializable id:ids){
				Object entity=this.getHibernateTemplate().get(entityClass, id);
				if(entity==null){
					throw new RuntimeException("您要查找的["+id+"]不存在"); 
				}
				this.getHibernateTemplate().delete(entity);
			}
		}
	}

	public void deleteAllObjects(Collection<T> entities) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().deleteAll(entities);
	}

	public List<T> findObjectsByConditionWithNoPage(String whereHql,
			final Object[] params, LinkedHashMap<String, String> orderby) {
		String hql="select o from "+entityClass.getSimpleName() +"  o  where 1=1  ";
		//System.out.println("hql  "+hql);
		
		//在select语句的后面这查询条件
		if(StringUtils.isNotBlank(whereHql)){
			hql=hql+whereHql;
		}
		//处理排序
		String orderbystr=buildOrderBy(orderby);
		//System.out.println("orderbystr  "+orderbystr);
		hql=hql+orderbystr;
		//System.out.println("hql  "+hql);
		
		final String fhql=hql;
		
		List<T>  list=(List<T>)this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException {
				Query query=session.createQuery(fhql);
				//设置参数 
				setParams(query, params);
				return query.list();
			}
		});
		return list;
	}

	public List<T> findObjectsByConditionWithNoPage(String whereHql,
			Object[] params) {
		// TODO Auto-generated method stub
		return this.findObjectsByConditionWithNoPage(whereHql, params,null);

	}

	public List<T> findObjectsByConditionWithNoPage(
			LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> findObjectsByConditionWithNoPage() {
		// TODO Auto-generated method stub
		return this.findObjectsByConditionWithNoPage(null, null,null);
	}

	public List<T> findObjectsByConditionWithNoPageCache(String whereHql,
			Object[] params, LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		return this.findObjectsByConditionWithNoPage(null, null,orderby);
	}
	
	/**
	 * 设置hql语句需要的参数
	 * @param query
	 * @param params
	 */
	public void setParams(Query query, Object[] params) {
		if(params!=null&&params.length>0){
			for(int i=0;i<params.length;i++){
				query.setParameter(i, params[i]);
			}
		}
	}
	/*
	 *  组织排序条件
	 *  orderby.put("o.id", "asc");
		orderby.put("o.name", "desc");
	 */
	public String buildOrderBy(LinkedHashMap<String, String> orderby) {
		StringBuffer buf=new StringBuffer("");
		if(orderby!=null&&!orderby.isEmpty()){
			buf.append("  order by ");
			for(Map.Entry<String, String> em:orderby.entrySet()){
				buf.append(em.getKey()+"  "+em.getValue()+",");
			}
			//去掉最后一个","
			buf.deleteCharAt(buf.length()-1);
		}
		return buf.toString();
	}
	/**
	 *  处理待二级缓存的查询
	 * @param whereHql
	 * @param params
	 * @param orderby
	 * @return
	 */
//	public List<T> findObjectsByConditionWithNoPageCache(String whereHql, final Object[] params, 
//			   LinkedHashMap<String, String> orderby) {
//		
//		//产生select语句 SELECT * FROM SysUserGroup o WHERE 
//		String hql="select o from "+entityClass.getSimpleName() +"  o  where 1=1  ";
//		
//		//在select语句的后面这查询条件
//		if(StringUtils.isNotBlank(whereHql)){
//			hql=hql+whereHql;
//		}
//		//处理排序
//		String orderbystr=buildOrderBy(orderby);
//		hql=hql+orderbystr;
//		System.out.println("二级缓存 hql  "+hql);
//		final String fhql=hql;
//		List<T>  list=(List<T>)this.getHibernateTemplate().execute(new HibernateCallback(){
//			public Object doInHibernate(Session session) throws HibernateException, SQLException {
//				Query query=session.createQuery(fhql);
//				//使用查询缓存,必须加该行代码
//				query.setCacheable(true);
//				//设置参数 
//				setParams(query,params);
//				return query.list();
//			}
//		});
//		return list;
//	}

	
}
