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
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("board/notice")
@RequiredArgsConstructor
public class NoticeBoardController
{
    private final BoardNoticeService boardService;
    private final BoardNoticeMapper boardMapper;

    @GetMapping("/updateBoard")
    public String updateBoardView(Long id, Model model)
    {
        model.addAttribute("boardNotice", toDto(boardService.getBoard(id)));
        return "/board/notice/updateBoard";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(@RequestParam("id") Long id)
    {
        boardService.deleteBoard(id);
        return "forward:getBoardList";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(@ModelAttribute BoardNoticeDto dto)
    {
        boardService.updateBoard(toEntity(dto));
        return "forward:getBoardList";
    }


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
        boardService.insertBoard(toEntity(dto));
        return "redirect:getBoardList";
    }

    @GetMapping("/getBoard")
    public String getBoard(Long id, Model model)
    {
        model.addAttribute("boardNotice", toDto(boardService.getBoard(id)));
        return "/board/notice/getBoard";
    }

    protected BoardNoticeDto toDto(BoardNotice e)
    {
        return boardMapper.toDto(e);
    }

    protected BoardNotice toEntity(BoardNoticeDto d)
    {
        return boardMapper.toEntity(d);
    }

}