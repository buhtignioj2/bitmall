package com.cafe24.bitmall.vo;

public class OrderVo {
    private Long no;
    private Long memberNo;
    private Long buyerNo;
    private Long recipientNo;
    
    @Override
    public String toString() {
	return "OrderVo [no=" + no + ", memberNo=" + memberNo + ", buyerNo=" + buyerNo + ", recipientNo=" + recipientNo
		+ "]";
    }
    public Long getNo() {
        return no;
    }
    public void setNo(Long no) {
        this.no = no;
    }
    public Long getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(Long memberNo) {
        this.memberNo = memberNo;
    }
    public Long getBuyerNo() {
        return buyerNo;
    }
    public void setBuyerNo(Long buyerNo) {
        this.buyerNo = buyerNo;
    }
    public Long getRecipientNo() {
        return recipientNo;
    }
    public void setRecipientNo(Long recipientNo) {
        this.recipientNo = recipientNo;
    }
}
