package com.yhkx.core.util;

import com.yhkx.core.model.offer.Offer;

/**
 * Redis-Key命名管理
 *
 * @author LiSs
 * @date on 2018/7/6
 */
public class RedisKeyUtil {

    /**
     * 这种无业务流程的方法可以不做javaDoc的注释，但是要以key结尾
     *
     * @param offer
     * @return
     */
    public static String getOfferRedisKey(Offer offer) {
        return "offer_cache_" + offer.getId();
    }

    public static String getOfferRedisKey(String offerId) {
        return "offer_cache_" + offerId;
    }

}
