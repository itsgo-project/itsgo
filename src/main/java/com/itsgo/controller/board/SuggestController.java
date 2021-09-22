package com.itsgo.controller.board;

import com.itsgo.domain.board.BoardSuggest;
import com.itsgo.dto.BoardSuggestDto;
import com.itsgo.mapstuct.BoardSuggestMapper;
import com.itsgo.service.board.BoardSuggestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("board/suggest")
public class SuggestController
{
    private final BoardSuggestService boardService;
    private final BoardSuggestMapper boardMapper;

    @RequestMapping("/getBoardList")
    public String getQBoardList(@PageableDefault Pageable pageable, Model model)
    {
        Page<BoardSuggest> boardList = boardService.getBoardList(pageable);
        model.addAttribute("boardList", boardList);
        return "/board/suggest/getBoardList";
    }

    @GetMapping("/insertBoard")
    public String insertBoardView()
    {
        return "/board/suggest/insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(@ModelAttribute BoardSuggestDto dto)
    {
        boardService.insertBoard(toEntity(dto));
        return "redirect:getBoardList";
    }

    @GetMapping("/getBoard")
    public String getBoard(Long id, Model model)
    {
        model.addAttribute("boardSuggest", toDto(boardService.getBoard(id)));
        return "/board/suggest/getBoard";
    }

    @GetMapping("/deleteBoard")
    public String deleteQboard(@RequestParam("id") Long id)
    {
        boardService.deleteBoard(id);
        return "redirect:getBoardList";
    }

    @GetMapping("/updateBoard")
    public String updateBoardView(@RequestParam("id") Long id, Model model)
    {
        model.addAttribute("boardSuggest", toDto(boardService.getBoard(id)));
        return "/board/suggest/updateBoard";
    }

    @PutMapping("/updateBoard")
    public String updateQBoard(@ModelAttribute BoardSuggestDto dto)
    {
        boardService.updateBoard(toEntity(dto));
        return "redirect:getBoardList";
    }

    protected BoardSuggestDto toDto(BoardSuggest e)
    {
        return boardMapper.toDto(e);
    }

    protected BoardSuggest toEntity(BoardSuggestDto d)
    {
        return boardMapper.toEntity(d);
    }

}