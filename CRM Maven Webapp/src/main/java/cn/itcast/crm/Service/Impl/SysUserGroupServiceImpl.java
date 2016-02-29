package cn.itcast.crm.Service.Impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.FlushMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.Bean.SysUserGroupSearch;
import cn.itcast.crm.Dao.ISysUserGroupDao;
import cn.itcast.crm.Service.ISysUserGroupService;
import cn.itcast.crm.domain.SysUserGroup;


@Transactional(readOnly=true)
@Service(ISysUserGroupService.SERVICE_NAME)
public class SysUserGroupServiceImpl implements ISysUserGroupService {

	@Resource(name=ISysUserGroupDao.SERVICE_NAME)
	private ISysUserGroupDao sysUserGroupDao;
 	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveSysUserGroup(SysUserGroup sysUserGroup) {
		sysUserGroupDao.save(sysUserGroup);
	}

	@SuppressWarnings("unchecked")
	public List<SysUserGroup> findSysUserGroups(SysUserGroupSearch sysUserGroupSearch) {
        if(sysUserGroupSearch==null){
			throw new RuntimeException("传递给业务层部门查询条件的对象为空");
		}
		
		//组织查询条件
		String whereHql="";
		
		//定义封装查询条件的List
		List paramList=new ArrayList();
		
		if(StringUtils.isNotBlank(sysUserGroupSearch.getName())){
			whereHql=" and o.name like ?";
			paramList.add("%"+sysUserGroupSearch.getName().trim()+"%");
		}
		
		Object[] params=paramList.toArray();
		
		//排序
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();
		orderby.put("o.id", "asc");
		
		return sysUserGroupDao.findObjectsByConditionWithNoPage(whereHql, params, orderby);
	}

	public SysUserGroup findSysUserGroupById(Integer id) {
		return sysUserGroupDao.findObjectById(id);
	}
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void updateSysUserGroup(SysUserGroup sysUserGroup) {
		sysUserGroupDao.update(sysUserGroup);
	}

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteSysUserGroupsByIds(Integer ... ids) {
		sysUserGroupDao.deleteByIds(ids);
	}

	public List<SysUserGroup> findAllSysUserGroups() {
		//排序
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();
		orderby.put("o.id", "asc");
		return sysUserGroupDao.findObjectsByConditionWithNoPage(orderby);
	}
}
