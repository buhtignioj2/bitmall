package com.cafe24.jblog.dto;

public class CartDTO {
    private Long no;
    private String name;
    private Long price;
    private Long count;
    private Long memberNo;
    private Long totalCount;
    private String newName;
  
    @Override
    public String toString() {
	return "CartDTO [no=" + no + ", name=" + name + ", price=" + price + ", count=" + count + ", memberNo="
		+ memberNo + ", totalCount=" + totalCount + ", newName=" + newName + "]";
    }
    public String getNewName() {
        return newName;
    }
    public void setNewName(String newName) {
        this.newName = newName;
    }
    public Long getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
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
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }
    public Long getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(Long memberNo) {
        this.memberNo = memberNo;
    }
}
