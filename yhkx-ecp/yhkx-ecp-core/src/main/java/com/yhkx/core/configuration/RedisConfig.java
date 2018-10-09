/*
package com.yhkx.core.configuration;


import com.yhkx.core.util.ApiLogger;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.ReadMode;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "spring.redisson")
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    private String readMode;

    private String password;

    private String retryAttempts;

    private String idleConnectionTimeout;

    private int maxConnectionSize;

    private int masterConnectionMinimumIdleSize;

    private int slaveConnectionMinimumIdleSize;

    private List<String> nodeAddresses;

    */
/**
     * 生产key的策略,注意：如果方法参数是引用类型，必须自己实现tostring方法，来区分不同的类实例
     *
     * @return
     *//*

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };

    }

    */
/**
     * 管理缓存
     *
     * @return
     *//*


    @SuppressWarnings("rawtypes")
    @Bean
    public CacheManager CacheManager(RedissonClient redissonClient) {
        Map<String, CacheConfig> config = new HashMap<String, CacheConfig>();
        //RLock
        config.put("testMap", new CacheConfig(24 * 60 * 1000, 12 * 60 * 1000));

        RedissonSpringCacheManager cacheManager = new RedissonSpringCacheManager(redissonClient, config);
        return cacheManager;
    }


    @Bean
    public RedissonClient initRedissonClient() {
        Config config = new Config();
        config.setLockWatchdogTimeout(20000);

        ClusterServersConfig serversConfig = config.useClusterServers();
        if (!(getPassword() == null || getPassword().equals(""))) {
            serversConfig.setPassword(password);
        }
        serversConfig.setReadMode(ReadMode.MASTER_SLAVE);

        serversConfig.setMasterConnectionMinimumIdleSize(masterConnectionMinimumIdleSize);
        serversConfig.setSlaveConnectionMinimumIdleSize(slaveConnectionMinimumIdleSize);
        serversConfig.setSubscriptionConnectionMinimumIdleSize(5);
        serversConfig.setScanInterval(3000);
        serversConfig.setSlaveConnectionPoolSize(maxConnectionSize);
        serversConfig.setMasterConnectionPoolSize(maxConnectionSize);

        // 使用 lambda 表达式以及函数操作(functional operation)
        nodeAddresses.forEach((node) -> serversConfig.addNodeAddress(node));
        try {
            RedissonClient redisson = Redisson.create(config);
            return redisson;
        } catch (RedisConnectionException e) {
            ApiLogger.redisLog("redis初始化异常", e);
            return null;
        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxConnectionSize() {
        return maxConnectionSize;
    }

    public void setMaxConnectionSize(int maxConnectionSize) {
        this.maxConnectionSize = maxConnectionSize;
    }

    public int getMasterConnectionMinimumIdleSize() {
        return masterConnectionMinimumIdleSize;
    }

    public void setMasterConnectionMinimumIdleSize(int masterConnectionMinimumIdleSize) {
        this.masterConnectionMinimumIdleSize = masterConnectionMinimumIdleSize;
    }

    public int getSlaveConnectionMinimumIdleSize() {
        return slaveConnectionMinimumIdleSize;
    }

    public void setSlaveConnectionMinimumIdleSize(int slaveConnectionMinimumIdleSize) {
        this.slaveConnectionMinimumIdleSize = slaveConnectionMinimumIdleSize;
    }

    public String getReadMode() {
        return readMode;
    }

    public void setReadMode(String readMode) {
        this.readMode = readMode;
    }

    public String getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(String retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public String getIdleConnectionTimeout() {
        return idleConnectionTimeout;
    }

    public void setIdleConnectionTimeout(String idleConnectionTimeout) {
        this.idleConnectionTimeout = idleConnectionTimeout;
    }

    public List<String> getNodeAddresses() {
        return nodeAddresses;
    }

    public void setNodeAddresses(List<String> nodeAddresses) {
        this.nodeAddresses = nodeAddresses;
    }
}
*/
