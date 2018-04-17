package com.cafe24.bitmall.vo;

public class PaymenthistoryDTO {

    private Long no;
    private Long orderNo;
    private String date;
    private String name;
    private String method;
    private Long price;
    private Long count;
    private String bankSender;
    private String state;
    
    @Override
    public String toString() {
	return "PaymenthistoryDTO [no=" + no + ", orderNo=" + orderNo + ", date=" + date + ", name=" + name
		+ ", method=" + method + ", price=" + price + ", count=" + count + ", bankSender=" + bankSender
		+ ", state=" + state + "]";
    }
    
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public Long getNo() {
        return no;
    }
    public void setNo(Long no) {
        this.no = no;
    }
    public Long getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public String getBankSender() {
        return bankSender;
    }
    public void setBankSender(String bankSender) {
        this.bankSender = bankSender;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    
}
