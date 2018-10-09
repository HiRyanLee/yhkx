package com.yhkx.restapi.controller;

import com.yhkx.core.model.offer.Offer;
import com.yhkx.core.service.OfferService;
import com.yhkx.core.util.ResultBean;
import com.yhkx.restapi.apiversion.ApiVersion;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Offer-控制器
 *
 * @author LiSs
 * @date on 2018/7/6
 */
@RestController
@ApiVersion(1)
@RequestMapping(value = "/offer")
public class OfferController {

    //@Autowired默认按类型匹配的方式，在容器查找匹配的Bean，当有且仅有一个匹配的Bean时，Spring将其注入@Autowired标注的变量中。
    //区分一下@Autowired和@Resource两个注解的区别：
    //@Autowired默认按照byType方式进行bean匹配，@Resource默认按照byName方式进行bean匹配
    //@Autowired是Spring的注解，@Resource是J2EE的注解，这个看一下导入注解的时候这两个注解的包名就一清二楚了
    @Autowired
    private OfferService offerService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value="保存Offer", notes="根据数据保存Offer")
    @ApiImplicitParam(name = "offer", value = "Offer实体", required = true, dataType = "Offer")
    @PostMapping(value = "/save_offer")
    public ResultBean<Offer> saveOffer(@RequestBody Offer offer) {
        offerService.saveOffer(offer);
        logger.info("info example 注意观察traceId");
        logger.info("info example 注意观察traceId");
        return new ResultBean<>(offer);
    }

    @GetMapping(value = "/get_offer_by_id/{offerId}")
    public ResultBean<Offer> getOfferById(@PathVariable String offerId) {
        Offer result = offerService.getOfferById(offerId);
        logger.error("error example");
        return new ResultBean<>(result);
    }
}
