package cn.itcast.crm.Dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import cn.itcast.crm.domain.SysUserGroup;

public interface ISysUserGroupDao extends ICommonDao<SysUserGroup> {
	public final static String  SERVICE_NAME="cn.itcast.crm.dao.impl.SysUserGroupDaoImpl";

}
