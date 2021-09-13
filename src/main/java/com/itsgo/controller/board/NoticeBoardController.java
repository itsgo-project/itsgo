package com.itsgo.controller.board;

import com.itsgo.domain.board.BoardNotice;
import com.itsgo.dto.BoardNoticeDto;
import com.itsgo.mapstuct.BoardNoticeMapper;
import com.itsgo.service.board.BoardNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("board/notice")
@RequiredArgsConstructor
public class NoticeBoardController
{
    private final BoardNoticeService boardService;
    private final BoardNoticeMapper boardMapper;

    @RequestMapping("/getBoardList")
    public String getBoardList(@PageableDefault Pageable pageable, Model model)
    {
        Page<BoardNotice> boardList = boardService.getBoardList(pageable);
        model.addAttribute("boardList", boardList);
        return "/board/notice/getBoardList";
    }
    //    임시
    @GetMapping("/adminPage")
    public String adminPage()
    {
        return "adminPage";
    }

    @GetMapping("/insertBoard")
    public String insertBoardView()
    {
        return "/board/notice/insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(@ModelAttribute BoardNoticeDto dto)
    {
        boardService.insertBoard(boardMapper.toEntity(dto));
        return "redirect:getBoardList";
    }


//    @PostMapping("/study/new")
//    public String create(@ModelAttribute BoardStudyDto dto, Model model, RedirectAttributes redirectAttributes) {
//        log.debug(dto.toString());
//        BoardStudy saveBoard = boardService.save(boardMapper.toEntity(dto));
//        redirectAttributes.addAttribute("id", saveBoard.getId());
//        return "redirect:/study/{id}";
//    }

//
//
//
//    @GetMapping("/getNBoard")
//    public String getNBoard(NBoard nBoard, Model model)
//    {
//        model.addAttribute("nBoard", nBoardService.getNBoard(nBoard));
//        return "getNBoard";
//    }
//
//    @GetMapping("/updateNBoard")
//    public String updateNBoardView(NBoard nBoard, Model model)
//    {
//        model.addAttribute("nBoard", nBoardService.getNBoard(nBoard));
//        return "updateNBoard";
//    }
//
//    @PostMapping("/updateNBoard")
//    public String updateNBoard(NBoard nBoard)
//    {
//        nBoardService.updateNBoard(nBoard);
//        return "forward:getNBoardList";
//    }
//

}