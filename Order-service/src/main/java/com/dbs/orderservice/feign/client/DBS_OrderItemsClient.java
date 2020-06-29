package com.dbs.orderservice.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbs.commons.vo.DBS_OrderItemsVO;
import com.dbs.commons.vo.DBS_OrdersVO;

@FeignClient(name="orderItem-service", url="http://localhost:8090/"/*, configuration = CustomFeignConfig.class*/)
public interface DBS_OrderItemsClient {

    @GetMapping("/orderItems")
    List<DBS_OrderItemsVO> getAll();

    @GetMapping("/orderItems/{id}")
    DBS_OrdersVO getById(@PathVariable(value = "1") String id);

    @PostMapping("/create")
    DBS_OrderItemsVO create(@RequestBody DBS_OrderItemsVO orderItemsVO);
}
