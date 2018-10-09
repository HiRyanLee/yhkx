package com.yhkx.core.model;

/**
 * 所有产品的抽象类
 *
 * @author LiSs
 * @date on 2018/7/6
 */
public abstract class AbsProduct {
    private String id;
    private String name;
    private Long price;

    public AbsProduct() {
    }

    public AbsProduct(String id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
