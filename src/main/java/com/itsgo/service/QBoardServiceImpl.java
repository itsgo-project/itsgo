package com.itsgo.service;

import com.itsgo.dto.QBoard;
import com.itsgo.repository.QBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QBoardServiceImpl implements QBoardService
{
    final private QBoardRepository qBoardRepository;

    public void makeData()
    {
        for(int i = 1; i <= 5; i++)
        {
            QBoard qboard = new QBoard();
            qboard.setTitle("제목" + i);
            qboard.setWrite("글쓴이" + i);
            qboard.setContent("아무내용");
            qBoardRepository.save(qboard);
        }
    }

    @Override
    public Page<QBoard> getQBoardList(Pageable pageable)
    {
        int page= (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 15, Sort.by("id").descending());

        return qBoardRepository.findAll(pageable);
    }

    @Override
    public void insertQBoard(QBoard qBoard)
    {
        qBoardRepository.save(qBoard);
    }

    @Override
    public QBoard getQBoard(QBoard qBoard)
    {
        return qBoardRepository.findById(qBoard.getId()).get();
    }

    @Override
    public void updateQBoard(QBoard qBoard)
    {
        QBoard findQBoard = qBoardRepository.findById(qBoard.getId()).get();
        System.out.println(qBoardRepository.findById(qBoard.getId()));
        findQBoard.setTitle(qBoard.getTitle());
        findQBoard.setContent(qBoard.getContent());
        qBoardRepository.save(findQBoard);
    }

    @Override
    public void deleteQBoard(QBoard qBoard)
    {
        qBoardRepository.deleteById(qBoard.getId());
    }
}
