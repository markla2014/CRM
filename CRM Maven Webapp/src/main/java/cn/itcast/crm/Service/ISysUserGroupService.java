package cn.itcast.crm.Service;

import java.util.List;

import cn.itcast.crm.Bean.SysUserGroupSearch;
import cn.itcast.crm.domain.SysUserGroup;

public interface ISysUserGroupService {
	public final static String  SERVICE_NAME="cn.itcast.crm.service.impl.SysUserGroupServiceImpl";
	public void saveSysUserGroup(SysUserGroup sysUserGroup);
	
	
	/**
	 *  按条件进行查询
	 * @param sysUserGroupSearch 封装的是查询条件
	 * @return
	 */
	public List<SysUserGroup> findSysUserGroups(SysUserGroupSearch sysUserGroupSearch);

    /**
     * 通过id查询部门信息
     * @param id
     * @return
     */
	public SysUserGroup findSysUserGroupById(Integer id);

    /**
     * 修改部门信息
     * @param sysUserGroup
     */
	public void updateSysUserGroup(SysUserGroup sysUserGroup);

	/**
	 * 通过id批量删除部门信息
	 * @param ids
	 */
	public void deleteSysUserGroupsByIds(Integer ... ids);

   /**
    * 查询所有的部门
    * @return
    */
	public List<SysUserGroup> findAllSysUserGroups();

}
