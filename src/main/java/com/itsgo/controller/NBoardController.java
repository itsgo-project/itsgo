package com.itsgo.controller;

import com.itsgo.dto.NBoard;
import com.itsgo.service.NBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class NBoardController
{
    final private NBoardService nBoardService;

    @RequestMapping("/getNBoardList")
    public String getNBoardList(@PageableDefault Pageable pageable, Model model)
    {
        Page<NBoard> nBoardList = nBoardService.getNBoardList(pageable);
        model.addAttribute("nBoardList", nBoardList);
        return "getNBoardList";
    }

    @GetMapping("/insertNBoard")
    public String insertNBoardView()
    {
        return "insertNBoard";
    }

    @PostMapping("/insertNBoard")
    public String insertNBoard(NBoard nBoard)
    {
        nBoardService.insertNBoard(nBoard);
        return "redirect:getNBoardList";
    }

    @GetMapping("/getNBoard")
    public String getNBoard(NBoard nBoard, Model model)
    {
        model.addAttribute("nBoard", nBoardService.getNBoard(nBoard));
        return "getNBoard";
    }

    @GetMapping("/updateNBoard")
    public String updateNBoardView(NBoard nBoard, Model model)
    {
        model.addAttribute("nBoard", nBoardService.getNBoard(nBoard));
        return "updateNBoard";
    }

    @PostMapping("/updateNBoard")
    public String updateNBoard(NBoard nBoard)
    {
        nBoardService.updateNBoard(nBoard);
        return "forward:getNBoardList";
    }

//    임시
    @GetMapping("/adminPage")
    public String adminPage()
    {
        return "adminPage";
    }
}