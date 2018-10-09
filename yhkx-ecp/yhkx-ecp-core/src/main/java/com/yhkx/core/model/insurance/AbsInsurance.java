package com.yhkx.core.model.insurance;

import com.yhkx.core.model.AbsProduct;

/**
 * 保险抽象类
 *
 * @author LiSs
 * @date on 2018/7/6
 */
public abstract class AbsInsurance extends AbsProduct {
    private String companyName;

    public AbsInsurance() {
    }

    public AbsInsurance(String id, String name, Long price, String companyName) {
        super(id, name, price);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
