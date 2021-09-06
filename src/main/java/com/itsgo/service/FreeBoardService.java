package com.itsgo.service;

import com.itsgo.dto.FreeBoard;

import java.util.List;

public interface FreeBoardService
{
    List<FreeBoard> getFreeBoardList(FreeBoard freeboard);

    void insertFreeBoard(FreeBoard freeBoard);

    FreeBoard getFreeBoard(FreeBoard freeBoard);

    void updateFreeBoard(FreeBoard freeBoard);

    void deleteFreeBoard(FreeBoard freeboard);
}
