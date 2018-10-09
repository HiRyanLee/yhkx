package com.yhkx.core.codegenerator.model;

/**
 * velocity需要用的列模型
 *
 * @author LiSs
 * @date on 2018/7/04
 */
public class Column {

	private String lowerProperty;

	private String property;

	private String column;

	private String javaType;

	private String jdbcType;

	private String remark;

	private int dataType;

	private  boolean allowNull;

	public boolean isAllowNull() {
		return allowNull;
	}

	public void setAllowNull(boolean allowNull) {
		this.allowNull = allowNull;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	private  int maxLength;



	public String getLowerProperty() {
		return lowerProperty;
	}

	public void setLowerProperty(String lowerProperty) {
		this.lowerProperty = lowerProperty;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String type) {
		this.javaType = type;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}


	
}