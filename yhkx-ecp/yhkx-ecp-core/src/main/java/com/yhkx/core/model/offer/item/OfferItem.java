package com.yhkx.core.model.offer.item;

import com.yhkx.core.model.limit.time.TimeLimit;
import com.yhkx.core.model.ticket.Ticket;

import java.util.List;

/**
 * @author LiSs
 * @date on 2018/7/6
 */
public class OfferItem {
    private List<Ticket> productList;
    private TimeLimit timeLimit;

    public List<Ticket> getProductList() {
        return productList;
    }

    public void setProductList(List<Ticket> productList) {
        this.productList = productList;
    }

    public TimeLimit getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(TimeLimit timeLimit) {
        this.timeLimit = timeLimit;
    }
}
