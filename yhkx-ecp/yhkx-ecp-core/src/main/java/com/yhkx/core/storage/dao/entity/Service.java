package com.yhkx.core.storage.dao.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
*service 表的数据对象
*
* @author uniqu
*/
@Table(name = "service")
public class Service implements Serializable {

    

        @Length(max=32,message="service_category_id 长度不能超过32")
                        @Column(name = "service_category_id")
private String serviceCategoryId;

    

        @Length(max=100,message="image_url 长度不能超过100")
                        @Column(name = "image_url")
private String imageUrl;

    

                        @Column(name = "default_price")
private BigDecimal defaultPrice;

    

        @Length(max=100,message="name 长度不能超过100")
                        @Column(name = "name")
private String name;

    

        @Length(max=32,message="guid 长度不能超过32")
            @NotNull(message = "guid not allow null")
                        @Id
            @Column(name = "guid")
private String guid;

    

        @Length(max=200,message="description 长度不能超过200")
                        @Column(name = "description")
private String description;


public String getServiceCategoryId() {
return serviceCategoryId;
}

public void setServiceCategoryId(String serviceCategoryId) {
this.serviceCategoryId = serviceCategoryId;
}

public String getImageUrl() {
return imageUrl;
}

public void setImageUrl(String imageUrl) {
this.imageUrl = imageUrl;
}

public BigDecimal getDefaultPrice() {
return defaultPrice;
}

public void setDefaultPrice(BigDecimal defaultPrice) {
this.defaultPrice = defaultPrice;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getGuid() {
return guid;
}

public void setGuid(String guid) {
this.guid = guid;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}
}