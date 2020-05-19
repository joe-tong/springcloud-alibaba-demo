package com.tpp.feign.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "order-service")
public interface OrderService {
}
