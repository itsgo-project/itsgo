package com.itsgo.service;

import com.itsgo.dto.NBoard;

import java.util.List;

public interface NBoardService
{
    List<NBoard> getNBoardList(NBoard nBoard);

    void insertNBoard(NBoard nBoard);

    NBoard getNBoard(NBoard nBoard);

    void updateNBoard(NBoard nBoard);

    void deleteNBoard(NBoard nboard);
}
