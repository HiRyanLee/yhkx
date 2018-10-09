package com.yhkx.core.service;

import com.yhkx.core.exception.RedisException;
import com.yhkx.core.model.offer.Offer;
import com.yhkx.core.storage.cache.OfferCacheImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Offer服务类
 * '@Service'用于标注业务层组件
 *
 * @author LiSs
 * @date on 2018/7/7
 */
@Service(value = "offerService")
public class OfferService {

    @Qualifier("offerCacheImpl")
    @Autowired()
    private OfferCacheImpl offerCache;

    public void saveOffer(Offer offer) {
        try {
            offerCache.saveOffer(offer);
        } catch (Exception e) {
            offerCache.saveOffer(offer);
        }
    }

    /**
     * 如果有NPE异常需要在接口描述中说明
     *
     * @param offerId
     * @return
     */
    public Offer getOfferById(String offerId) {
        Offer offer;
        try {
            offer = offerCache.getOfferById(offerId);
        } catch (RedisException e) {
            offer = offerCache.getOfferById(offerId);
        }

        return offer;
    }

}
