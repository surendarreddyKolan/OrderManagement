package com.dbs.orderitemservice.controller;

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
import com.dbs.commons.vo.DBS_OrderItemsVO;
import com.dbs.orderitemservice.service.DBS_OrdersItemsService;

@RestController
@RequestMapping("/orderItems")
public class DBS_OrderItemsController {
	
	@Autowired
	private DBS_OrdersItemsService orderItemsService;

    @GetMapping
    public ResponseEntity<DBS_ResponseWarapperVO> listOrdersItems(){
    	List<DBS_OrderItemsVO> orderItemsVoList = orderItemsService.getAll();
        return new ResponseEntity<DBS_ResponseWarapperVO>(new DBS_ResponseWarapperVO(true, 
        		HttpStatus.OK.toString(), orderItemsVoList, "Order record(s) retrieved count is 1 "), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<DBS_ResponseWarapperVO> getByOrderItemId(@PathVariable Long id){
    	DBS_OrderItemsVO orderItemsVo=null;
		try {
			orderItemsVo = orderItemsService.getById(id);
			return new ResponseEntity<DBS_ResponseWarapperVO>(new DBS_ResponseWarapperVO(true, HttpStatus.OK.toString(), orderItemsVo, "Order Item record retrieved for Order Item Id : "+id), HttpStatus.OK);
		} catch (DBS_RecordNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<DBS_ResponseWarapperVO>(new DBS_ResponseWarapperVO(true, HttpStatus.OK.toString(), orderItemsVo, "No Records available for Order Item Id : "+id), HttpStatus.OK);
		}
    }

    @PostMapping("/create")
    public ResponseEntity<DBS_ResponseWarapperVO> create(@RequestBody DBS_OrderItemsVO orderItemsVO) {
    	DBS_OrderItemsVO createdUser=null;
		try {
			createdUser = orderItemsService.create(orderItemsVO);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DBS_ResponseWarapperVO>(new DBS_ResponseWarapperVO(false, HttpStatus.BAD_REQUEST.toString(), null, "Exception occured while creating OrderItem :: Please check wit support team :: "), HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity<DBS_ResponseWarapperVO>(new DBS_ResponseWarapperVO(true, HttpStatus.OK.toString(), createdUser, "Order Item created successfully"), HttpStatus.OK);
    }
}
