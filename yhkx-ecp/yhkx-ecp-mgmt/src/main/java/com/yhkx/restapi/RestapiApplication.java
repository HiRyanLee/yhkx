package com.yhkx.restapi;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.autoconfigure.webservices.WebServicesAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.ConsulAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 纯REST-API启动器
 *
 * @author LiSs
 * @date on 2018/7/04
 */
//@SpringBootApplication注解默认只扫描该注解注解类所在的包，即默认只扫描com.yhkx.restapi包下的bean
//注意，com.yhkx.restapi.config下有一个WebConfig，其中指定了需要向Spring容器注册的Bean
//@SpringBootApplication注解中的exclude属性显示指定要排除的类
@SpringBootApplication(exclude = {
        WebServicesAutoConfiguration.class,
        RedisAutoConfiguration.class,
        RabbitAutoConfiguration.class,
        SessionAutoConfiguration.class,
        SocialWebAutoConfiguration.class,
        ThymeleafAutoConfiguration.class,
        SecurityAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class,
        MultipartAutoConfiguration.class,
        SpringDataWebAutoConfiguration.class,
        WebSocketAutoConfiguration.class,
        ActiveMQAutoConfiguration.class,
        ArtemisAutoConfiguration.class,
        EmbeddedLdapAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})

//@EnableDiscoveryClient
@EnablePrometheusEndpoint
//@EnableSpringBootMetricsCollector
//@EnableRetry
@EnableAspectJAutoProxy
@EnableAsync
public class RestapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }
}
