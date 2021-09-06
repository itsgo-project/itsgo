package com.itsgo.service;

import com.itsgo.dto.FreeBoard;
import com.itsgo.repository.FreeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBoardServiceImpl implements FreeBoardService
{
    final private FreeBoardRepository freeBoardRepository;

    public List<FreeBoard> getFreeBoardList(FreeBoard freeboard)
    {
        return (List<FreeBoard>) freeBoardRepository.findAll();
    }

    public void insertFreeBoard(FreeBoard freeBoard)
    {
        freeBoardRepository.save(freeBoard);
    }

    public FreeBoard getFreeBoard(FreeBoard freeBoard)
    {
        return null;
    }

    public void updateFreeBoard(FreeBoard freeBoard)
    {

    }

    public void deleteFreeBoard(FreeBoard freeboard)
    {

    }
}
