package com.yhkx.core.storage.dao.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
*order_item 表的数据对象
*
* @author uniqu
*/
@Table(name = "order_item")
public class OrderItem implements Serializable {

    

                        @Column(name = "price")
private BigDecimal price;

    

        @Length(max=100,message="image_url 长度不能超过100")
                        @Column(name = "image_url")
private String imageUrl;

    

        @Length(max=32,message="service_id 长度不能超过32")
                        @Column(name = "service_id")
private String serviceId;

    

        @Length(max=32,message="guid 长度不能超过32")
            @NotNull(message = "guid not allow null")
                        @Id
            @Column(name = "guid")
private String guid;

    

        @Length(max=200,message="detail 长度不能超过200")
                        @Column(name = "detail")
private String detail;

    

        @Length(max=32,message="order_id 长度不能超过32")
                        @Column(name = "order_id")
private String orderId;

    

                        @Column(name = "status")
private Integer status;


public BigDecimal getPrice() {
return price;
}

public void setPrice(BigDecimal price) {
this.price = price;
}

public String getImageUrl() {
return imageUrl;
}

public void setImageUrl(String imageUrl) {
this.imageUrl = imageUrl;
}

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

public String getDetail() {
return detail;
}

public void setDetail(String detail) {
this.detail = detail;
}

public String getOrderId() {
return orderId;
}

public void setOrderId(String orderId) {
this.orderId = orderId;
}

public Integer getStatus() {
return status;
}

public void setStatus(Integer status) {
this.status = status;
}
}