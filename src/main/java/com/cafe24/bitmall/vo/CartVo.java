package com.cafe24.bitmall.vo;

public class CartVo {
    private Long product_no;
    private Long member_no;
    private Long count;
    private Long price;
    
    @Override
    public String toString() {
	return "CartVo [product_no=" + product_no + ", member_no=" + member_no + ", count=" + count + ", price=" + price
		+ "]";
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    public Long getProduct_no() {
        return product_no;
    }
    public void setProduct_no(Long product_no) {
        this.product_no = product_no;
    }
    public Long getMember_no() {
        return member_no;
    }
    public void setMember_no(Long member_no) {
        this.member_no = member_no;
    }
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }
    
}
