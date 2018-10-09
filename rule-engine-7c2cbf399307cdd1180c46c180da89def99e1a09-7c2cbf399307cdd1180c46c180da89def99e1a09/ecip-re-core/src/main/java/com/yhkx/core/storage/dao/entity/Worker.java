package com.yhkx.core.storage.dao.entity;
import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


/**
*worker 表的数据对象
*
* @author uniqu
*/
@Table(name = "worker")
public class Worker implements Serializable {

    

        @Length(max=50,message="phone_no 长度不能超过50")
                        @Column(name = "phone_no")
private String phoneNo;

    

        @Length(max=50,message="image_url 长度不能超过50")
                        @Column(name = "image_url")
private String imageUrl;

    

        @Length(max=32,message="guid 长度不能超过32")
            @NotNull(message = "guid not allow null")
                        @Id
            @Column(name = "guid")
private String guid;

    

        @Length(max=50,message="last_name 长度不能超过50")
                        @Column(name = "last_name")
private String lastName;

    

        @Length(max=200,message="remark 长度不能超过200")
                        @Column(name = "remark")
private String remark;

    

        @Length(max=50,message="first_name 长度不能超过50")
                        @Column(name = "first_name")
private String firstName;


public String getPhoneNo() {
return phoneNo;
}

public void setPhoneNo(String phoneNo) {
this.phoneNo = phoneNo;
}

public String getImageUrl() {
return imageUrl;
}

public void setImageUrl(String imageUrl) {
this.imageUrl = imageUrl;
}

public String getGuid() {
return guid;
}

public void setGuid(String guid) {
this.guid = guid;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

public String getRemark() {
return remark;
}

public void setRemark(String remark) {
this.remark = remark;
}

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}
}