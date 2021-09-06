package com.itsgo.service;

import com.itsgo.dto.NBoard;
import com.itsgo.repository.NBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NBoardServiceImpl implements NBoardService
{
    final private NBoardRepository nBoardRepository;

    @Override
    public List<NBoard> getNBoardList(NBoard nBoard)
    {
        return (List<NBoard>)nBoardRepository.findAll();
    }

    @Override
    public void insertNBoard(NBoard nBoard)
    {
        nBoardRepository.save(nBoard);
    }

    @Override
    public NBoard getNBoard(NBoard nBoard)
    {
        return nBoardRepository.findById(nBoard.getId()).get();
    }

    @Override
    public void updateNBoard(NBoard nBoard)
    {
        NBoard findNBoard = nBoardRepository.findById(nBoard.getId()).get();
        findNBoard.setTitle(nBoard.getTitle());
        findNBoard.setContent(nBoard.getContent());
        nBoardRepository.save(findNBoard);
    }

    @Override
    public void deleteNBoard(NBoard nBoard)
    {
        nBoardRepository.deleteById(nBoard.getId());
    }
}