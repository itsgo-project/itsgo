package com.itsgo.service.board;

import com.itsgo.domain.board.Board;
import com.itsgo.domain.board.BoardNotice;
import com.itsgo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    public T getBoard(Long id)
    {
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

//    public T getNBoard(T board)
//    {
//        return boardRepository.findById(board.getId()).get();
//    }
//
//    @Override
//    public void updateNBoard(NBoard nBoard)
//    {
//        NBoard findNBoard = nBoardRepository.findById(nBoard.getId()).get();
//        findNBoard.setTitle(nBoard.getTitle());
//        findNBoard.setContent(nBoard.getContent());
//        nBoardRepository.save(findNBoard);
//    }

//    @Override
//    public void deleteNBoard(NBoard nBoard)
//    {
//        nBoardRepository.deleteById(nBoard.getId());
//    }

}
