package com.itsgo.service;

import com.itsgo.dto.QBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QBoardService
{
    Page<QBoard> getQBoardList(Pageable pageable);

    void insertQBoard(QBoard qBoard);

    QBoard getQBoard(QBoard qBoard);

    void updateQBoard(QBoard qBoard);

    void deleteQBoard(QBoard qBoard);
}
