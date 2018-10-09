package com.yhkx.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig  {
    @Bean
    public CustomConsulServerFilter serverListFilter() {
        CustomConsulServerFilter filter = new CustomConsulServerFilter();
        return filter;
    }
}
