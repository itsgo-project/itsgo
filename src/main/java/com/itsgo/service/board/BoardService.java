package com.itsgo.service.board;

import com.itsgo.domain.board.Board;
import com.itsgo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class BoardService<T extends Board, R extends BoardRepository<T>> {

    protected final R boardRepository;

    public T save(T board) {
        return boardRepository.save(board);
    }

    public Optional<T> find(Long id) {
        return boardRepository.findById(id);
    }

}
