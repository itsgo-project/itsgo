package com.itsgo.controller.board;

import com.itsgo.domain.board.BoardStudy;
import com.itsgo.dto.BoardStudyDto;
import com.itsgo.mapstuct.BoardStudyMapper;
import com.itsgo.service.board.BoardStudyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("board")
@RequiredArgsConstructor
public class StudyBoardController {
    private final BoardStudyService boardService;
    private final BoardStudyMapper boardMapper;

    @GetMapping("/study/new")
    public String create(Model model) {
        // model.addAttribute(new BoardStudyDto());
        return "/study/newForm";
    }

    @PostMapping("/study/new")
    public String create(@ModelAttribute BoardStudyDto dto, Model model, RedirectAttributes redirectAttributes) {
        log.debug(dto.toString());
        BoardStudy saveBoard = boardService.save(boardMapper.toEntity(dto));
        redirectAttributes.addAttribute("id", saveBoard.getId());
        return "redirect:/study/{id}";
    }

    @GetMapping("/study/{id}")
    public String view(@PathVariable Long id, Model model) {
        // model.addAttribute(new BoardStudyDto());
        return "/study/viewForm";
    }

    @GetMapping("/study/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // model.addAttribute(new BoardStudyDto());
        return "/study/viewForm";
    }

    /*@PostMapping("/study/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // model.addAttribute(new BoardStudyDto());
        return "/study/viewForm";
    }*/

}
