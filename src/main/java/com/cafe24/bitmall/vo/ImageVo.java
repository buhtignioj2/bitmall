package com.cafe24.bitmall.vo;

public class ImageVo {
    private Long no;
    private String name;
    private String newName;
    private Long productNo;
    
    @Override
    public String toString() {
	return "ImageVo [no=" + no + ", name=" + name + ", newName=" + newName + ", productNo=" + productNo + "]";
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
    public String getNewName() {
        return newName;
    }
    public void setNewName(String newName) {
        this.newName = newName;
    }
    public Long getProductNo() {
        return productNo;
    }
    public void setProductNo(Long productNo) {
        this.productNo = productNo;
    }
}
