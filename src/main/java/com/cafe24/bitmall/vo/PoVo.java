package com.cafe24.bitmall.vo;

public class PoVo {
    private Long orderNo;
    private Long productNo;
    private Long price;
    private Long count;
    
    @Override
    public String toString() {
	return "PoVo [orderNo=" + orderNo + ", productNo=" + productNo + ", price=" + price + ", count=" + count + "]";
    }
    public Long getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }
    public Long getProductNo() {
        return productNo;
    }
    public void setProductNo(Long productNo) {
        this.productNo = productNo;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }
}
