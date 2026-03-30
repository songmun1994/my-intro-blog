package com.myhome.myintro.web.admin;

import com.myhome.myintro.admin.dto.MenuContentDTO;
import com.myhome.myintro.admin.mapper.MenuContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/content")
public class AdminContentController {

	@Autowired
	private MenuContentMapper contentMapper;

	// 에디터 화면 열기
	@GetMapping("/edit")
	public String editContent(@RequestParam("menuId") String menuId, Model model) {
		MenuContentDTO content = contentMapper.selectContentByMenuId(menuId);

		// 없으면 빈 객체 전달 (NullPointerException 방지)
		if (content == null) {
			content = new MenuContentDTO();
			content.setMenuId(menuId);
			content.setHtmlContent("");
		}

		model.addAttribute("content", content);
		model.addAttribute("menuId", menuId);

		return "admin/content/contentEdit";
	}

	// 에디터 내용 저장
	@PostMapping("/save")
	public String saveContent(MenuContentDTO contentDTO) {
		// 기존 내용이 있는지 확인
		MenuContentDTO existing = contentMapper.selectContentByMenuId(contentDTO.getMenuId());

		if (existing == null) {
			contentMapper.insertContent(contentDTO);
		} else {
			contentMapper.updateContent(contentDTO);
		}

		return "redirect:/admin/menu/manage"; // 저장 후 메뉴 관리 리스트로 이동
	}
}
