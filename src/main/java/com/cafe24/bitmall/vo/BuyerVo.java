package com.cafe24.bitmall.vo;

public class BuyerVo {
    private Long no;
    private String buyer;
    private String phone;
    private String email;
    private String location;

    public Long getNo() {
        return no;
    }
    public void setNo(Long no) {
        this.no = no;
    }
    public String getBuyer() {
        return buyer;
    }
    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString() {
	return "BuyerVo [no=" + no + ", buyer=" + buyer + ", phone=" + phone + ", email=" + email + ", location="
		+ location + "]";
    }
   
}
