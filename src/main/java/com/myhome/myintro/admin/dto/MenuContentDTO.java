package com.myhome.myintro.admin.dto;

import org.apache.ibatis.type.Alias;

@Alias("MenuContentDTO")
public class MenuContentDTO {

    private Integer contentIdx;
    private String menuId;
    private String htmlContent;
    private String regDate;
    private String modDate;

    public Integer getContentIdx() {
        return contentIdx;
    }

    public void setContentIdx(Integer contentIdx) {
        this.contentIdx = contentIdx;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getModDate() {
        return modDate;
    }

    public void setModDate(String modDate) {
        this.modDate = modDate;
    }
}
