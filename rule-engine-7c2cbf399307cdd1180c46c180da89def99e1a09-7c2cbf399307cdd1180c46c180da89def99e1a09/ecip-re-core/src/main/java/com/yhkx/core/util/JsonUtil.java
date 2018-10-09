package com.yhkx.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.yhkx.core.model.limit.time.TimeLimit;
import com.yhkx.core.model.offer.item.OfferItem;
import com.yhkx.core.model.ticket.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * 输出转换工具类
 *
 * @author LiSs
 * @date on 2018/7/7
 */
public class JsonUtil {

    public static String parseJsonNode2String(JsonNode jsonNode) throws JsonProcessingException {
        ObjectMapper renderResult = new ObjectMapper();
        return renderResult.writeValueAsString(jsonNode);
    }

    public static JsonNode parseString2JsonNode(String jsonStr) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonStr);
        return jsonNode;
    }

    public static String parseObject2String(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    public static <T extends Object> T parseString2Object(String objStr, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return (T) mapper.readValue(objStr, clazz);
        } catch (IOException e) {
            return null;
        }
    }

    static class BodyEntity {
        private String code;
        private String msg;
        private Object result;

        public BodyEntity(String code, String msg, Object result) {
            this.code = code;
            this.msg = msg;
            this.result = result;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Object getResult() {
            return result;
        }

        public void setResult(Object result) {
            this.result = result;
        }
    }

    public static void main(String[] args) throws IOException {
        OfferItem offerItem = new OfferItem();
        offerItem.setTimeLimit(new TimeLimit(10L, 10L));
        List<Ticket> productList = new ArrayList<>();
        productList.add(new Ticket("1", "1", 1L, "1", "1"));
        productList.add(new Ticket("2", "2", 2L, "2", "2"));
        offerItem.setProductList(productList);

        String jsonStr = parseObject2String(offerItem);
        OfferItem offerItem1 = parseString2Object(jsonStr, OfferItem.class);
        JsonNode jsonNode = parseString2JsonNode(jsonStr);
        String id =jsonNode.get("timeLimit").toString();
        String s = parseJsonNode2String(jsonNode);
        out.println("end");
    }
}
