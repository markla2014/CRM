package cn.itcast.crm.Web.Action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import cn.itcast.crm.Bean.SysUserGroupSearch;
import cn.itcast.crm.annotation.Limit;
import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.domain.SysUserGroup;
import cn.itcast.crm.Service.ISysUserGroupService;
import cn.itcast.crm.Util.DataType;
import cn.itcast.crm.Web.Form.SysUserGroupForm;

import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class SysUserGroupAction extends BaseAction  implements ModelDriven<SysUserGroupForm>{
	
	private SysUserGroupForm sysUserGroupForm=new SysUserGroupForm();
	
	//获取业务层的对象(本项目struts2和spring是分离的)
	private ISysUserGroupService sysUserGroupService=
		   (ISysUserGroupService)ServiceProvinder.getService(ISysUserGroupService.SERVICE_NAME);
	
	/**
	 * 保存部门信息
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@Limit(module="group",privilege="save")
	public String save() throws IllegalAccessException, InvocationTargetException{
		//实例化po对象
		SysUserGroup sysUserGroup=new SysUserGroup();
		
		//赋值vo对象的值到po中
		BeanUtils.copyProperties(sysUserGroup, sysUserGroupForm);
		//调用业务层保存po对象
		sysUserGroupService.saveSysUserGroup(sysUserGroup);
		
		return "listAction";
	}
	
	/**
	 * 修改部门信息
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@Limit(module="group",privilege="update")
	public String update() throws IllegalAccessException, InvocationTargetException{
		//实例化po对象
		SysUserGroup sysUserGroup=new SysUserGroup();
		
		//赋值vo对象的值到po中
		BeanUtils.copyProperties(sysUserGroup, sysUserGroupForm);
		//调用业务层保存po对象
		sysUserGroupService.updateSysUserGroup(sysUserGroup);
		
		return "listAction";
	}

	/**
	 * 显示部门信息查询页面
	 * @return
	 */
	@Limit(module="group",privilege="list")
	public String list(){
		
		//实例化封装查询条件的javabean
		SysUserGroupSearch  sysUserGroupSearch=new SysUserGroupSearch();
		sysUserGroupSearch.setName(sysUserGroupForm.getName());
		
		
		//调用业务层的方法查询
		List<SysUserGroup> sysUserGroups=sysUserGroupService.findSysUserGroups(sysUserGroupSearch);
		System.out.println("sysUserGroups.size() "+sysUserGroups.size());
		request.setAttribute("sysUserGroups", sysUserGroups);
		
		return "list";
	}

	/**
	 * 显示部门信息修改页面
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Limit(module="group",privilege="edit")
	public String edit() throws IllegalAccessException, InvocationTargetException{
		
		//获取部门的id
		String sid=sysUserGroupForm.getId();
		if(StringUtils.isNotBlank(sid)){
			Integer id=Integer.parseInt(sid.trim());
		    
			//调用业务层方法.通过部门的id查询部门信息
			SysUserGroup sysUserGroup=sysUserGroupService.findSysUserGroupById(id);
			
			//处理部门编辑页面显示要编辑的信息
			BeanUtils.copyProperties(sysUserGroupForm, sysUserGroup);
			
			
			return "edit";
		}
		
		return null;
	}
	
	/**
	 * 删除部门信息
	 * @return
	 */
	@Limit(module="group",privilege="delete")
	public String delete(){
		//获取部门的ids
		String[] sids=request.getParameterValues("ids");
		Integer ids[]=DataType.converterStringArray2IntegerArray(sids);
		if(ids!=null){
			//删除
			sysUserGroupService.deleteSysUserGroupsByIds(ids);
			return "listAction";
		}
		return null;
	}
	
	/**
	 * 显示部门信息添加页面
	 * @return
	 */
	@Limit(module="group",privilege="add")
	public String add(){
		return "add";
	}
	
	public SysUserGroupForm getModel() {
		return sysUserGroupForm;
	}
}
