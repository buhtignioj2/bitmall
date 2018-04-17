package com.cafe24.bitmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.OrderDao;
import com.cafe24.bitmall.vo.BuyerVo;
import com.cafe24.bitmall.vo.OrderVo;
import com.cafe24.bitmall.vo.PaymenthistoryDTO;
import com.cafe24.bitmall.vo.PaymenthistoryVo;
import com.cafe24.bitmall.vo.PoVo;
import com.cafe24.bitmall.vo.RecipientVo;

@Service
public class OrderService {
    
    @Autowired
    private OrderDao orderDao;

    public void insertBuyer(BuyerVo buyerVo) {
	orderDao.insertBuyer( buyerVo );
    }

    public void insertRecipient(RecipientVo recipientVo) {
	orderDao.insertRecipient( recipientVo );
    }

    public void insertOrder(OrderVo orderVo) {
	orderDao.insertOrder( orderVo );
    }

    public OrderVo getByNo(Long no) {
	return orderDao.getByNo( no );
    }

    public void insertPaymenthistory(PaymenthistoryVo paymenthistoryVo) {
	orderDao.insertPaymenthistory( paymenthistoryVo );
    }

    public List<PaymenthistoryDTO> getList() {
	return orderDao.getList();
    }

    public void delete(Long no) {
	orderDao.deleteOrder(no);
    }

    public List<PaymenthistoryDTO> getListByNo(Long no) {
	return orderDao.getListByNo(no);
    }

    public void setPO(PoVo vo) {
	orderDao.insertPO(vo);
    }

}
