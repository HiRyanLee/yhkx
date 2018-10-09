package com.yhkx.core.storage.dao.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
*work_order 表的数据对象
*
* @author uniqu
*/
@Table(name = "work_order")
public class WorkOrder implements Serializable {

    

        @Length(max=32,message="order_item_id 长度不能超过32")
                        @Column(name = "order_item_id")
private String orderItemId;

    

                        @Column(name = "create_time")
private Date createTime;

    

                        @Column(name = "complete_time")
private Date completeTime;

    

        @Length(max=32,message="guid 长度不能超过32")
            @NotNull(message = "guid not allow null")
                        @Id
            @Column(name = "guid")
private String guid;

    

        @Length(max=200,message="remark 长度不能超过200")
                        @Column(name = "remark")
private String remark;

    

        @Length(max=32,message="worker_id 长度不能超过32")
                        @Column(name = "worker_id")
private String workerId;

    

                        @Column(name = "status")
private Integer status;


public String getOrderItemId() {
return orderItemId;
}

public void setOrderItemId(String orderItemId) {
this.orderItemId = orderItemId;
}

public Date getCreateTime() {
return createTime;
}

public void setCreateTime(Date createTime) {
this.createTime = createTime;
}

public Date getCompleteTime() {
return completeTime;
}

public void setCompleteTime(Date completeTime) {
this.completeTime = completeTime;
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

public String getWorkerId() {
return workerId;
}

public void setWorkerId(String workerId) {
this.workerId = workerId;
}

public Integer getStatus() {
return status;
}

public void setStatus(Integer status) {
this.status = status;
}
}