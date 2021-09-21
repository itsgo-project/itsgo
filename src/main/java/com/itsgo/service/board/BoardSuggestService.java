package com.itsgo.service.board;

import com.itsgo.domain.board.BoardSuggest;
import com.itsgo.repository.BoardSuggestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@Slf4j
public class BoardSuggestService extends BoardService<BoardSuggest, BoardSuggestRepository>
{
    public BoardSuggestService(BoardSuggestRepository boardRepository)
    {
        super(boardRepository);
    }
}