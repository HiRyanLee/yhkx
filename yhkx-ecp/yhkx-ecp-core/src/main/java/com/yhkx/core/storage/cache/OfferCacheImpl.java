package com.yhkx.core.storage.cache;

import com.yhkx.core.exception.RedisException;
import com.yhkx.core.model.offer.Offer;
import com.yhkx.core.util.JsonUtil;
import com.yhkx.core.util.RedisKeyUtil;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static java.lang.System.out;

/**
 * '@Repository'用于标注数据访问组件，即DAO组件
 *
 * @author LiSs
 * @date on 2018/7/6
 */
@Repository(value = "offerCacheImpl")
public class OfferCacheImpl {

   // @Autowired
    private RedissonClient redissonClient;

    /**
     * 根据offerId获取Offer
     */
    public Offer getOfferById(String offerId) throws RedisException {
        String offerRedisKey = RedisKeyUtil.getOfferRedisKey(offerId);
        RBucket<Object> existOffer = redissonClient.getBucket(offerRedisKey);
        out.println("existOffer=" + existOffer.get());
        return JsonUtil.parseString2Object(existOffer.get().toString(), Offer.class);
    }

    /**
     * 存储Offer
     *
     * @param offer
     * @throws RedisException
     */
    public void saveOffer(Offer offer) throws RedisException {
        String offerRedisKey = RedisKeyUtil.getOfferRedisKey(offer);
        RBucket<Object> existOffer = redissonClient.getBucket(offerRedisKey);
        out.println("existOffer=" + existOffer.get());
        try {
            existOffer.set(JsonUtil.parseObject2String(offer));
        } catch (Exception e) {
        }

        out.println("existOffer=" + existOffer.get());
    }
}