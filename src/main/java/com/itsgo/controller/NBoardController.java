package com.itsgo.controller;

import com.itsgo.dto.NBoard;
import com.itsgo.service.NBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NBoardController
{
    final private NBoardService nBoardService;

    @RequestMapping("/getNBoardList")
    public String getNBoardList(Model model, NBoard nBoard)
    {
        List<NBoard> nBoardList = nBoardService.getNBoardList(nBoard);
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

    @PostMapping("/updateNBoard")
    public String updateNBoard(NBoard nBoard)
    {
        nBoardService.updateNBoard(nBoard);
        return "forward:getNBoardList";
    }
}