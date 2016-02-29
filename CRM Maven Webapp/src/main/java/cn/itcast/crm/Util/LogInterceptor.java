package cn.itcast.crm.Util;

import javax.annotation.Resource;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.util.log.SystemLogHandler;

import cn.itcast.crm.Bean.SystemLog;
import cn.itcast.crm.Service.SystemLogService;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LogInterceptor extends AbstractInterceptor {
	@Resource
	private SystemLogService logService;
 //不需要日志的action
	public static final String[] excludeActionMethodNames=new String[]{"loginout"};
	public static final String[] excludeActionClassNames=new String[]{};
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		invocation.invoke();
		String actionClassName=invocation.getAction().getClass().getName();
		String actionMethodName=invocation.getProxy().getMethod();
		if(ArrayUtils.contains(excludeActionClassNames, actionClassName)){
		     return null;	
		}
		
		if(ArrayUtils.contains(excludeActionMethodNames, actionMethodName)){
		     return null;	
		}
		String adm=(String)ServletActionContext.getRequest().getSession().getValue("username");
		String ip=ServletActionContext.getRequest().getRemoteAddr();
		SystemLog log=new SystemLog();
		// TODO Auto-generated method stub
		log.setIp(ip);
		log.setOperation(actionMethodName);
		log.setIp(ip);
		log.setName(adm);
		return null;
	}

}
