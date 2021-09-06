package com.itsgo.controller;

import com.itsgo.dto.QBoard;
import com.itsgo.service.QBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QBoardController
{
    final private QBoardService qBoardService;

    @RequestMapping("/getQBoardList")
    public String getQBoardList(Model model, QBoard qBoard)
    {
        List<QBoard> qBoardList = qBoardService.getQBoardList(qBoard);
        model.addAttribute("qBoardList", qBoardList);
        return "getQBoardList";
    }

    @GetMapping("/insertQBoard")
    public String insertQBoardView()
    {
        return "insertQBoard";
    }

    @PostMapping("/insertQBoard")
    public String insertQBoard(QBoard qBoard)
    {
        qBoardService.insertQBoard(qBoard);
        return "redirect:getQBoardList";
    }

    @GetMapping("/getQBoard")
    public String getQBoard(QBoard qBoard, Model model)
    {
        model.addAttribute("qBoard", qBoardService.getQBoard(qBoard));
        return "getQBoard";
    }

    @PostMapping("/updateQBoard")
    public String updateQBoard(QBoard qBoard)
    {
        qBoardService.updateQBoard(qBoard);
        return "forward:getQBoardList";
    }

    @GetMapping("/deleteQBoard")
    public String deleteQboard(QBoard qBoard)
    {
        qBoardService.deleteQBoard(qBoard);
        return "forward:getQBoardList";
    }

}