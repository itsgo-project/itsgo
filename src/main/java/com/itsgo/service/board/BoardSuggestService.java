package com.itsgo.service.board;

import com.itsgo.domain.board.BoardNotice;
import com.itsgo.domain.board.BoardSuggest;
import com.itsgo.repository.BoardSuggestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<BoardSuggest> getBoardList(Pageable pageable)
    {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 15, Sort.by("id").descending());
        return boardRepository.findAll(pageable);
    }
}