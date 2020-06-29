package com.dbs.orderservice.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.commons.entity.DBS_OrdersEntity;
import com.dbs.commons.exception.DBS_RecordNotFoundException;
import com.dbs.commons.vo.DBS_OrdersVO;
import com.dbs.orderservice.dao.DBS_OrdersDAO;
import com.dbs.orderservice.service.DBS_OrdersService;

@Service
public class DBS_OrderServiceImpl implements DBS_OrdersService {
	
	@Autowired
	private DBS_OrdersDAO ordersDAO;

	public DBS_OrdersVO getById(Long orderId) throws DBS_RecordNotFoundException {
		Optional<DBS_OrdersEntity> orderEntity = ordersDAO.findById(orderId);
		 if(orderEntity.isPresent()) {
			 DBS_OrdersVO orderVO = convertEntity2VO(orderEntity.get());
	            return orderVO;
	        } else {
	            throw new DBS_RecordNotFoundException("No Order available with Order Id "+orderId);
	        }
	}

	public List<DBS_OrdersVO> getAll() {
		List<DBS_OrdersVO> orderVos = new ArrayList<DBS_OrdersVO>();
		List<DBS_OrdersEntity> ordersList = (List<DBS_OrdersEntity>)ordersDAO.findAll();
        
        if(!ordersList.isEmpty()) {
        	for (DBS_OrdersEntity orderEntity : ordersList) {
        		DBS_OrdersVO orderVo = convertEntity2VO(orderEntity);
				orderVos.add(orderVo);
    		}
        } 
		return orderVos;
	}

	public DBS_OrdersVO create(DBS_OrdersVO orderVo) {
		DBS_OrdersVO convertEntity2VO = null;
		DBS_OrdersEntity convertVO2Entity = convertVO2Entity(orderVo);
		DBS_OrdersEntity orderEntity = ordersDAO.save(convertVO2Entity);
		convertEntity2VO = convertEntity2VO(orderEntity);
		return convertEntity2VO;
	}
	
	private DBS_OrdersEntity convertVO2Entity(DBS_OrdersVO ordersVO) {
		DBS_OrdersEntity orderEntity = new DBS_OrdersEntity();
		BeanUtils.copyProperties(ordersVO, orderEntity);
		return orderEntity;
	}

	private DBS_OrdersVO convertEntity2VO(DBS_OrdersEntity orderEntity) {
		DBS_OrdersVO ordersVO = new DBS_OrdersVO();
		BeanUtils.copyProperties(orderEntity, ordersVO);
		return ordersVO;
	}
}
