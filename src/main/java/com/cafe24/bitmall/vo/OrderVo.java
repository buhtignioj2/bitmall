package com.cafe24.bitmall.vo;

public class OrderVo {

    private Long no;
    private String poNo;
    private String orderMan;
    private Long price;
    private String location;
    private String date;
    private Long memberNo;
    private String phone;
    private String content;
    private String email;

    @Override
    public String toString() {
	return "OrderVo [no=" + no + ", poNo=" + poNo + ", orderMan=" + orderMan + ", price=" + price + ", location="
		+ location + ", date=" + date + ", memberNo=" + memberNo + ", phone=" + phone + ", content=" + content + ", email=" + email + "]";
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Long getNo() {
	return no;
    }

    public void setNo(Long no) {
	this.no = no;
    }

    public String getPoNo() {
	return poNo;
    }

    public void setPoNo(String poNo) {
	this.poNo = poNo;
    }

    public String getOrderMan() {
	return orderMan;
    }

    public void setOrderMan(String orderMan) {
	this.orderMan = orderMan;
    }

    public Long getPrice() {
	return price;
    }

    public void setPrice(Long price) {
	this.price = price;
    }

    public String getLocation() {
	return location;
    }

    public void setLocation(String location) {
	this.location = location;
    }

    public String getDate() {
	return date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public Long getMemberNo() {
	return memberNo;
    }

    public void setMemberNo(Long memberNo) {
	this.memberNo = memberNo;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

}
