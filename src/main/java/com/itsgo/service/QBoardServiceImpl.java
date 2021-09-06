package com.itsgo.service;

import com.itsgo.dto.QBoard;
import com.itsgo.repository.QBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QBoardServiceImpl implements QBoardService
{
    final private QBoardRepository qBoardRepository;

    @Override
    public List<QBoard> getQBoardList(QBoard qBoard)
    {
        return (List<QBoard>) qBoardRepository.findAll();
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
