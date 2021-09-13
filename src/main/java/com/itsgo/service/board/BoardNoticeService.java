package com.itsgo.service.board;

import com.itsgo.domain.board.BoardNotice;
import com.itsgo.repository.BoardNoticeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BoardNoticeService extends BoardService<BoardNotice, BoardNoticeRepository>
{
    public BoardNoticeService(BoardNoticeRepository boardRepository)
    {
        super(boardRepository);
    }
}