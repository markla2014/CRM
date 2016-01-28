package cn.itcast.crm.Dao.Impl;

import org.springframework.stereotype.Repository;

import cn.itcast.crm.Dao.ISysUserGroupDao;
import cn.itcast.crm.domain.SysUserGroup;

@Repository(ISysUserGroupDao.SERVICE_NAME)
public class SysUserGroupDaoImpl extends CommonDaoImpl<SysUserGroup> implements ISysUserGroupDao {

}
