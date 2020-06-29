package com.dbs.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.commons.exception.DBS_RecordNotFoundException;
import com.dbs.commons.responsewrapper.DBS_ResponseWarapperVO;
import com.dbs.commons.vo.DBS_OrdersVO;
import com.dbs.orderservice.feign.client.DBS_OrderItemsClient;
import com.dbs.orderservice.service.DBS_OrdersService;

@RequestMapping("/Orders")
@RestController
public class DBS_OrderController {

    @Autowired
    private DBS_OrderItemsClient orderItems;

    @Autowired
	private DBS_OrdersService orderService;

    @GetMapping
    public ResponseEntity<DBS_ResponseWarapperVO> getAll(){
    	List<DBS_OrdersVO> orderItemsVoList = orderService.getAll();
        return new ResponseEntity<DBS_ResponseWarapperVO>(new DBS_ResponseWarapperVO(true, 
        		HttpStatus.OK.toString(), orderItemsVoList, "Order record(s) retrieved count is 1 "), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<DBS_ResponseWarapperVO> getById(@PathVariable Long id){
    	DBS_OrdersVO orderItemsVo=null;
		try {
			orderItemsVo = orderService.getById(id);
			return new ResponseEntity<DBS_ResponseWarapperVO>(new DBS_ResponseWarapperVO(true, HttpStatus.OK.toString(), orderItemsVo, "Order record retrieved for Order Id : "+id), HttpStatus.OK);
		} catch (DBS_RecordNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<DBS_ResponseWarapperVO>(new DBS_ResponseWarapperVO(true, HttpStatus.OK.toString(), orderItemsVo, "No Records available for Order Id : "+id), HttpStatus.OK);
		}
    }

    @PostMapping("/create")
    public ResponseEntity<DBS_ResponseWarapperVO> create(@RequestBody DBS_OrdersVO ordersVO) {
    	DBS_OrdersVO createdUser=null;
		try {
			createdUser = orderService.create(ordersVO);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DBS_ResponseWarapperVO>(new DBS_ResponseWarapperVO(false, HttpStatus.BAD_REQUEST.toString(), null, "Exception occured while creating Order :: Please check with support team :: "), HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity<DBS_ResponseWarapperVO>(new DBS_ResponseWarapperVO(true, HttpStatus.OK.toString(), createdUser, "Order created successfully"), HttpStatus.OK);
    }

}
