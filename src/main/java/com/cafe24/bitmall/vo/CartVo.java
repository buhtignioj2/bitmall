package com.cafe24.bitmall.vo;

public class CartVo {
    private Long productNo;
    private Long memberNo;
    private Long count;
    private Long price;

    @Override
    public String toString() {
	return "CartVo [productNo=" + productNo + ", memberNo=" + memberNo + ", count=" + count + ", price=" + price
		+ "]";
    }
    public Long getProductNo() {
        return productNo;
    }
    public void setProductNo(Long productNo) {
        this.productNo = productNo;
    }
    public Long getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(Long memberNo) {
        this.memberNo = memberNo;
    }
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
}
