package com.yhkx.core.model.ticket;


import com.yhkx.core.model.AbsProduct;

/**
 * 机票Model
 *
 * @author LiSs
 * @date on 2018/7/6
 */
public class Ticket extends AbsProduct {
    private String flightNo;
    private String companyCode;

    public Ticket() {
    }

    public Ticket(String id, String name, Long price, String flightNo, String companyCode) {
        super(id, name, price);
        this.flightNo = flightNo;
        this.companyCode = companyCode;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
