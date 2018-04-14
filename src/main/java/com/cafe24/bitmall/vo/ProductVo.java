package com.cafe24.bitmall.vo;

public class ProductVo {
    private Long no;
    private String name;
    private Long price;
    private String coname;
    private String content;
    private Long status;
    private Long categoryNo;
    private String categoryName;
    private String newName;

    @Override
    public String toString() {
	return "ProductVo [no=" + no + ", name=" + name + ", price=" + price + ", coname=" + coname + ", content="
		+ content + ", status=" + status + ", categoryNo=" + categoryNo + ", categoryName=" + categoryName
		+ ", newName=" + newName + "]";
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
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    public String getConame() {
        return coname;
    }
    public void setConame(String coname) {
        this.coname = coname;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Long getStatus() {
        return status;
    }
    public void setStatus(Long status) {
        this.status = status;
    }
    public Long getCategoryNo() {
        return categoryNo;
    }
    public void setCategoryNo(Long categoryNo) {
        this.categoryNo = categoryNo;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getNewName() {
        return newName;
    }
    public void setNewName(String newName) {
        this.newName = newName;
    }
}
