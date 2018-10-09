package com.yhkx.core.storage.dao.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * contract_info 表的数据对象
 *
 * @author uniqu
 */
@Table(name = "contract_info")
public class ContractInfo implements Serializable {

    /**
     * ��ϵ������
     */


    @Length(max = 50, message = "contractor 长度不能超过50")
    @Column(name = "contractor")
    private String contractor;

    /**
     * �绰����
     */


    @Length(max = 50, message = "phone_no 长度不能超过50")
    @Column(name = "phone_no")
    private String phoneNo;

    /**
     * ���У�Ĭ�����ţ���ʡ�������Ҫ����չ�ֶ�
     */


    @Length(max = 20, message = "city 长度不能超过20")
    @Column(name = "city")
    private String city;

    /**
     * ��ϸ��ַ
     */


    @Length(max = 200, message = "detail_address 长度不能超过200")
    @Column(name = "detail_address")
    private String detailAddress;


    @Length(max = 32, message = "guid 长度不能超过32")
    @NotNull(message = "guid not allow null")
    @Id
    @Column(name = "guid")
    private String guid;


    @Length(max = 32, message = "user_info_id 长度不能超过32")
    @Column(name = "user_info_id")
    private String userInfoId;


    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }
}