package cn.itcast.crm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/*
 * po对象,这里的值要和数据库对象
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "sys_user_group")
public class SysUserGroup implements java.io.Serializable {
	private Integer id;
	private String remark; // 备注
	private String name; // 部门名称
	private String principal; // 部门负责人
	private String incumbent; // 部门职能
	
	//一个部门包含多个用户,不做配置
	//private Set users=new HashSet(0);
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Type(type="integer")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	 @Column(name = "remark")
	 @Type(type="text")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
   @Column(name="name",length=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    @Column(name="principal",length=50)
	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}
     @Column(name="incumbent",length=200)
	public String getIncumbent() {
		return incumbent;
	}

	public void setIncumbent(String incumbent) {
		this.incumbent = incumbent;
	}
}
