package com.itsgo.service;

import com.itsgo.dto.QBoard;

import java.util.List;

public interface QBoardService
{
    List<QBoard> getQBoardList(QBoard qBoard);

    void insertQBoard(QBoard qBoard);

    QBoard getQBoard(QBoard qBoard);

    void updateQBoard(QBoard qBoard);

    void deleteQBoard(QBoard qBoard);
}
