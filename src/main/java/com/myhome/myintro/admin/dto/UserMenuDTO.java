package com.myhome.myintro.admin.dto;

import org.apache.ibatis.type.Alias;

@Alias("UserMenuDTO")
public class UserMenuDTO {

    // PK
    private String menuIdx;

    private String menuId;
    private String parentMenuIdx;
    private String menuDepth;
    private String sortNo;

    private String menuName;
    private String menuDesc;

    private String pageTitle;
    private String pageKeyword;

    private String menuType;   // BOARD / HTML / URL
    private String menuUrl;    // URL 타입일 때만 사용

    private String exposeYn;
    private String useYn;
    private String delYn;

    private String regDate;
    private String regIdx;
    private String regId;
    private String regName;

    private String modDate;
    private String modIdx;
    private String modId;
    private String modName;

    public String getMenuIdx() {
        return menuIdx;
    }

    public void setMenuIdx(String menuIdx) {
        this.menuIdx = menuIdx;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getParentMenuIdx() {
        return parentMenuIdx;
    }

    public void setParentMenuIdx(String parentMenuIdx) {
        this.parentMenuIdx = parentMenuIdx;
    }

    public String getMenuDepth() {
        return menuDepth;
    }

    public void setMenuDepth(String menuDepth) {
        this.menuDepth = menuDepth;
    }

    public String getSortNo() {
        return sortNo;
    }

    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageKeyword() {
        return pageKeyword;
    }

    public void setPageKeyword(String pageKeyword) {
        this.pageKeyword = pageKeyword;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getExposeYn() {
        return exposeYn;
    }

    public void setExposeYn(String exposeYn) {
        this.exposeYn = exposeYn;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getRegIdx() {
        return regIdx;
    }

    public void setRegIdx(String regIdx) {
        this.regIdx = regIdx;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getModDate() {
        return modDate;
    }

    public void setModDate(String modDate) {
        this.modDate = modDate;
    }

    public String getModIdx() {
        return modIdx;
    }

    public void setModIdx(String modIdx) {
        this.modIdx = modIdx;
    }

    public String getModId() {
        return modId;
    }

    public void setModId(String modId) {
        this.modId = modId;
    }

    public String getModName() {
        return modName;
    }

    public void setModName(String modName) {
        this.modName = modName;
    }
}
