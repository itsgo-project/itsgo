package com.itsgo.controller.board;

import com.itsgo.domain.board.BoardSuggest;
import com.itsgo.mapstuct.BoardSuggestMapper;
import com.itsgo.service.board.BoardSuggestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

//
//    @GetMapping("/insertQBoard")
//    public String insertQBoardView()
//    {
//        return "insertQBoard";
//    }
//
//    @PostMapping("/insertQBoard")
//    public String insertQBoard(QBoard qBoard)
//    {
//        qBoardService.insertQBoard(qBoard);
//        return "redirect:getQBoardList";
//    }
//
//    @GetMapping("/getQBoard")
//    public String getQBoard(QBoard qBoard, Model model)
//    {
//        model.addAttribute("qBoard", qBoardService.getQBoard(qBoard));
//        return "getQBoard";
//    }
//
//    @GetMapping("/updateQBoard")
//    public String updateQBoardView(QBoard qBoard, Model model)
//    {
//        model.addAttribute("qBoard", qBoardService.getQBoard(qBoard));
//        return "updateQBoard";
//    }
//
//    @PostMapping("/updateQBoard")
//    public String updateQBoard(QBoard qBoard)
//    {
//        qBoardService.updateQBoard(qBoard);
//        return "forward:getQBoardList";
//    }
//
//    @GetMapping("/deleteQBoard")
//    public String deleteQboard(QBoard qBoard)
//    {
//        qBoardService.deleteQBoard(qBoard);
//        return "forward:getQBoardList";
//    }

}