package com.yhkx.core.storage.dao.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
*skill_info 表的数据对象
*
* @author uniqu
*/
@Table(name = "skill_info")
public class SkillInfo implements Serializable {

    

        @Length(max=32,message="service_id 长度不能超过32")
                        @Column(name = "service_id")
private String serviceId;

    

        @Length(max=32,message="guid 长度不能超过32")
            @NotNull(message = "guid not allow null")
                        @Id
            @Column(name = "guid")
private String guid;

        /**
    * �����ȣ�������
    */
    

                        @Column(name = "proficiency")
private Integer proficiency;

    

        @Length(max=32,message="worker_id 长度不能超过32")
                        @Column(name = "worker_id")
private String workerId;


public String getServiceId() {
return serviceId;
}

public void setServiceId(String serviceId) {
this.serviceId = serviceId;
}

public String getGuid() {
return guid;
}

public void setGuid(String guid) {
this.guid = guid;
}

public Integer getProficiency() {
return proficiency;
}

public void setProficiency(Integer proficiency) {
this.proficiency = proficiency;
}

public String getWorkerId() {
return workerId;
}

public void setWorkerId(String workerId) {
this.workerId = workerId;
}
}