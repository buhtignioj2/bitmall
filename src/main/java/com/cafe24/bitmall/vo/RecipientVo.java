package com.cafe24.bitmall.vo;

public class RecipientVo {
    private Long no;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String content;
    
    @Override
    public String toString() {
	return "RecipientVo [no=" + no + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address="
		+ address + ", content=" + content + "]";
    }
    public Long getNo() {
        return no;
    }
    public void setNo(Long no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
   
}
