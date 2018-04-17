package com.cafe24.bitmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.BuyerVo;
import com.cafe24.bitmall.vo.OrderVo;
import com.cafe24.bitmall.vo.PaymenthistoryDTO;
import com.cafe24.bitmall.vo.PaymenthistoryVo;
import com.cafe24.bitmall.vo.PoVo;
import com.cafe24.bitmall.vo.RecipientVo;

@Repository
public class OrderDao {

    @Autowired
    private SqlSession sqlSession;
    
    public boolean insertBuyer(BuyerVo buyerVo) {
	return sqlSession.insert( "order.insertBuyer", buyerVo ) == 1;
    }

    public boolean insertRecipient(RecipientVo recipientVo) {
	return sqlSession.insert( "order.insertRecipient", recipientVo ) == 1;
    }

    public boolean insertOrder(OrderVo orderVo) {
	return sqlSession.insert( "order.insertOrder", orderVo ) == 1;
    }

    public OrderVo getByNo(Long no) {
	return sqlSession.selectOne( "order.selectAll", no );
    }

    public boolean insertPaymenthistory(PaymenthistoryVo paymenthistoryVo) {
	return sqlSession.insert( "order.insertPaymenthistory", paymenthistoryVo ) == 1;
    }

    public List<PaymenthistoryDTO> getList() {
	return sqlSession.selectList( "order.seletcList" );
    }

    public boolean deleteOrder(Long no) {
	return sqlSession.delete( "order.delete" ) == 1;
    }

    public List<PaymenthistoryDTO> getListByNo(Long no) {
	return sqlSession.selectList( "order.getListByNo", no );
    }

    public boolean insertPO(PoVo vo) {
	return sqlSession.insert( "order.insertPO", vo ) == 1;
    }

}
