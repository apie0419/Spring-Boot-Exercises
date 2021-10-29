package com.example.accessingdatajpa.config;

import java.time.Duration;

import com.github.benmanes.caffeine.cache.Caffeine;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;

public class CaffeineCacheConfig {
    public static final String CAFFEINE_CACHE_MANAGER = "caffeineCacheManager";
    @Bean(CAFFEINE_CACHE_MANAGER)
    public CacheManager caffeineCacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterAccess(Duration.ofMinutes(30))
                .initialCapacity(100)
                .maximumSize(1000));
        return caffeineCacheManager;
    }
}
