package com.itsgo.service.board;

import com.itsgo.domain.board.Board;
import com.itsgo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

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
        boardRepository.upHit(id);
        return boardRepository.findById(id).get();
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
