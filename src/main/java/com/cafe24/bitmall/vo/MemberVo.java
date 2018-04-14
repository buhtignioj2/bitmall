package com.cafe24.bitmall.vo;

public class MemberVo {
    private Long no;
    private String id;
    private String password;
    private String birth;
    private String name;
    private String phone;
    private String email;
    private String role;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Long getNo() {
        return no;
    }
    public void setNo(Long no) {
        this.no = no;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
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
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
	return "MemberVo [no=" + no + ", id=" + id + ", password=" + password + ", birth=" + birth + ", name=" + name
		+ ", phone=" + phone + ", email=" + email + ", role=" + role + ", address=" + address
		+ "]";
    }
}
