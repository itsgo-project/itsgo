package com.itsgo.service;

import com.itsgo.dto.BoardSuggestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QBoardService
{
    Page<BoardSuggestDto> getQBoardList(Pageable pageable);

    void insertQBoard(BoardSuggestDto qBoard);

    BoardSuggestDto getQBoard(BoardSuggestDto qBoard);

    void updateQBoard(BoardSuggestDto qBoard);

    void deleteQBoard(BoardSuggestDto qBoard);
}
