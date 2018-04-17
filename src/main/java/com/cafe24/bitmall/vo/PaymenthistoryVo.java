package com.cafe24.bitmall.vo;

public class PaymenthistoryVo {

    private Long no;
    private Long price;
    private String method;
    private String bankSender;
    private String approvalNumber;
    private String cardKinds;
    private String bankKinds;
    private String halbu;
    private String date;
    private Long orderNo;
    private Long count;
    
    
    @Override
    public String toString() {
	return "PaymenthistoryVo [no=" + no + ", price=" + price + ", method=" + method + ", bankSender=" + bankSender
		+ ", approvalNumber=" + approvalNumber + ", cardKinds=" + cardKinds + ", bankKinds=" + bankKinds
		+ ", halbu=" + halbu + ", date=" + date + ", orderNo=" + orderNo + ", count=" + count + "]";
    }
    
    public Long getNo() {
        return no;
    }
    public void setNo(Long no) {
        this.no = no;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getBankSender() {
        return bankSender;
    }
    public void setBankSender(String bankSender) {
        this.bankSender = bankSender;
    }
    public String getApprovalNumber() {
        return approvalNumber;
    }
    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }
    public String getCardKinds() {
        return cardKinds;
    }
    public void setCardKinds(String cardKinds) {
        this.cardKinds = cardKinds;
    }
    public String getBankKinds() {
        return bankKinds;
    }
    public void setBankKinds(String bankKinds) {
        this.bankKinds = bankKinds;
    }
    public String getHalbu() {
        return halbu;
    }
    public void setHalbu(String halbu) {
        this.halbu = halbu;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Long getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }
}
