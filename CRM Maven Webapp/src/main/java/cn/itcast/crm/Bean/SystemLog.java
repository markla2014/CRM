package cn.itcast.crm.Bean;

import java.util.Date;

public class SystemLog {
  private Date time;
  private String operation;
  private String ip;
  private String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
public String getOperation() {
	return operation;
}
public void setOperation(String operation) {
	this.operation = operation;
}
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
  
  
}
