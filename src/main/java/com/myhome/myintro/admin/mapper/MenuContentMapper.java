package com.myhome.myintro.admin.mapper;

import com.myhome.myintro.admin.dto.MenuContentDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuContentMapper {

    // 메뉴 ID로 콘텐츠 단건 조회
    MenuContentDTO selectContentByMenuId(String menuId);

    // 콘텐츠 신규 등록
    void insertContent(MenuContentDTO contentDTO);

    // 콘텐츠 수정
    void updateContent(MenuContentDTO contentDTO);
}
