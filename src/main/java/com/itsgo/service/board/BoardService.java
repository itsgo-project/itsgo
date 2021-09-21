package com.itsgo.service.board;

import com.itsgo.domain.board.Board;
import com.itsgo.domain.board.BoardNotice;
import com.itsgo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public abstract class BoardService<T extends Board, R extends BoardRepository<T>> {

    protected final R boardRepository;

    public T save(T board) {
        return boardRepository.save(board);
    }

    public Optional<T> find(Long id) {
        return boardRepository.findById(id);
    }

    public T getBoard(Long id)
    {
//        boardRepository.upHit();
        return boardRepository.findById(id).get();
    }

    public Page<T> getBoardList(Pageable pageable)
    {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 15, Sort.by("id").descending());
        return boardRepository.findAll(pageable);
    }

    public void insertBoard(T board)
    {
        boardRepository.save(board);
    }

    public void deleteBoard(Long id)
    {
        boardRepository.deleteById(id);
    }

    public void updateBoard(T board)
    {
        boardRepository.save(board);
    }



}
