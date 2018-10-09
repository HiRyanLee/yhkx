package com.yhkx.core.model.offer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yhkx.core.model.limit.time.TimeLimit;
import com.yhkx.core.model.offer.item.OfferItem;
import com.yhkx.core.model.ticket.Ticket;
import com.yhkx.core.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Offer模型
 *
 * @author LiSs
 * @date on 2018/7/6
 */
public class Offer {
    private String id;
    private List<OfferItem> offerItemList;
    private TimeLimit timeLimit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OfferItem> getOfferItemList() {
        return offerItemList;
    }

    public void setOfferItemList(List<OfferItem> offerItemList) {
        this.offerItemList = offerItemList;
    }

    public TimeLimit getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(TimeLimit timeLimit) {
        this.timeLimit = timeLimit;
    }

    public static void main(String[] args) throws JsonProcessingException {
        Offer offer = new Offer();
        offer.setId("123");

        List<OfferItem> offerItemList = new ArrayList<>();
        OfferItem offerItem = new OfferItem();

        List<Ticket> ticketList = new ArrayList<>();

        ticketList.add(new Ticket("1", "1", 1L, "1", "1"));
        offerItem.setProductList(ticketList);
        offerItem.setTimeLimit(new TimeLimit(20L, 20L));

        offerItemList.add(offerItem);

        offer.setOfferItemList(offerItemList);
        offer.setTimeLimit(new TimeLimit(30L, 30L));

        out.println(JsonUtil.parseObject2String(offer));
    }
}

