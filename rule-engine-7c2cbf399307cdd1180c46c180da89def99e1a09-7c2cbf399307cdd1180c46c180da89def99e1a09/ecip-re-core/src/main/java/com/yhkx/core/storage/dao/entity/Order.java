package com.yhkx.core.storage.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import java.util.Date;


import java.math.BigDecimal;

/**
 * order 表的数据对象
 *
 * @author uniqu
 */
@Table(name = "order")
public class Order implements Serializable {


    @Length(max = 50, message = "order_no 长度不能超过50")
    @Column(name = "order_no")
    private String orderNo;

    /**
     * ԤԼʱ��
     */


    @Column(name = "appointment_time")
    private Date appointmentTime;


    @Column(name = "total_price")
    private BigDecimal totalPrice;


    @Column(name = "create_time")
    private Date createTime;


    @Length(max = 32, message = "contract_id 长度不能超过32")
    @Column(name = "contract_id")
    private String contractId;

    /**
     * ����
     */


    @Length(max = 32, message = "guid 长度不能超过32")
    @NotNull(message = "guid not allow null")
    @Id
    @Column(name = "guid")
    private String guid;


    @Length(max = 200, message = "remark 长度不能超过200")
    @Column(name = "remark")
    private String remark;


    @Length(max = 32, message = "user_info_id 长度不能超过32")
    @Column(name = "user_info_id")
    private String userInfoId;


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }
}