package com.itsgo.service.board;

import com.itsgo.domain.board.BoardStudy;
import com.itsgo.repository.BoardStudyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BoardStudyService extends BoardService<BoardStudy, BoardStudyRepository> {

    public BoardStudyService(BoardStudyRepository boardRepository) {
        super(boardRepository);
    }
}

