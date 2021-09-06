package com.itsgo.controller;

import com.itsgo.dto.FreeBoard;
import com.itsgo.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FreeBoardController
{
    final FreeBoardService freeBoardservice;

    @RequestMapping("/getFreeBoardList")
    public String getFreeBoardList(Model model, FreeBoard freeBoard)
    {
        List<FreeBoard> freeBoardList = freeBoardservice.getFreeBoardList(freeBoard);
        model.addAttribute("freeBoardList", freeBoardList);
        return "getFreeBoardList";
    }

    @GetMapping("/insertFreeBoard")
    public String insertFreeBoardView()
    {
        return "insertFreeBoard";
    }

    @PostMapping("/insertFreeBoard")
    public String insertFreeBoard(FreeBoard freeBoard)
    {
        freeBoardservice.insertFreeBoard(freeBoard);
        return "redirect:getFreeBoardList";
    }
}
