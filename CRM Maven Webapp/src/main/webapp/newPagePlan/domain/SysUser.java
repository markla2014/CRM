package cn.itcast.crm.domain;

import java.sql.Date;
/**
 * 多的一端
 */
@SuppressWarnings("serial")
public class SysUser implements java.io.Serializable {

	private Integer id;
	private String creator; // #创建人
	private String createTime; // 创建时间 yyyy-mm-dd HH24:mm:ss
	private String updater; // 修改人
	private String updateTime; // 修建时间 yyyy-mm-dd HH24:mm:ss
	private String remark;
	private String name;
	private String cnname;
	private String password;
	private String address;
	private String telephone;
	private String email;
	private Date beginDate; // 起始有效期 yyyy-mm-dd
	private Date endDate; // 终止有效期 yyyy-mm-dd

	// 多个用户对应一个角色(权限组)

	// 多个用户属于一个部门

	private String accessFileLevel;
	private String status; // #状态(Y N)
	private String commendMan;
	private String movetelePhone;
	private String nowAddress;
	private String nowtelePhone;
	private String identityCode;
	private String insuranceCode;
	private String instancyLinkman;
	private String instancytelePhone;
	private String sex;
	private Date birthday; // 出生日期
	private String personnelType;
	private String duty;
	private Date workDate; // 入职日期
	private String highSchool;
	private String finishSchool;
	private Date finishSchoolDate; // 毕业日期
	private String consortName;
	private String youngoneName;
	private String officetelePhone;
	private String consorttelePhone;
	private String avocation;
	private String consortCompany;
	private String strongSuit;
	private String commUniCate;
	private String bringup;
	private String organise;
	private String analyse;
	private String planing;
	private String empolder;
	private String relation;

	public SysUser() {
	}
}
