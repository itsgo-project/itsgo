package com.itsgo.service;

import com.itsgo.dto.NBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NBoardService
{
    Page<NBoard> getNBoardList(Pageable pageable);

    void insertNBoard(NBoard nBoard);

    NBoard getNBoard(NBoard nBoard);

    void updateNBoard(NBoard nBoard);

    void deleteNBoard(NBoard nboard);
}
