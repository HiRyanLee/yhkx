package com.yhkx.core.storage.dao.entity;
import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


/**
*user_info 表的数据对象
*
* @author uniqu
*/
@Table(name = "user_info")
public class UserInfo implements Serializable {

    

                        @Column(name = "gender")
private Integer gender;

        /**
    * ΢��open id
    */
    

        @Length(max=50,message="open_id 长度不能超过50")
                        @Column(name = "open_id")
private String openId;

    

        @Length(max=50,message="nick_name 长度不能超过50")
                        @Column(name = "nick_name")
private String nickName;

    

        @Length(max=32,message="default_contract_id 长度不能超过32")
                        @Column(name = "default_contract_id")
private String defaultContractId;

    

        @Length(max=32,message="guid 长度不能超过32")
            @NotNull(message = "guid not allow null")
                        @Id
            @Column(name = "guid")
private String guid;

    

        @Length(max=50,message="last_name 长度不能超过50")
                        @Column(name = "last_name")
private String lastName;

    

        @Length(max=50,message="first_name 长度不能超过50")
                        @Column(name = "first_name")
private String firstName;

    

                        @Column(name = "age")
private Integer age;


public Integer getGender() {
return gender;
}

public void setGender(Integer gender) {
this.gender = gender;
}

public String getOpenId() {
return openId;
}

public void setOpenId(String openId) {
this.openId = openId;
}

public String getNickName() {
return nickName;
}

public void setNickName(String nickName) {
this.nickName = nickName;
}

public String getDefaultContractId() {
return defaultContractId;
}

public void setDefaultContractId(String defaultContractId) {
this.defaultContractId = defaultContractId;
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

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public Integer getAge() {
return age;
}

public void setAge(Integer age) {
this.age = age;
}
}