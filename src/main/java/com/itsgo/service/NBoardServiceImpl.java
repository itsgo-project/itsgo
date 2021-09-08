package com.itsgo.service;

import com.itsgo.dto.NBoard;
import com.itsgo.repository.NBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NBoardServiceImpl implements NBoardService
{
    final private NBoardRepository nBoardRepository;

    @Override
    public Page<NBoard> getNBoardList(Pageable pageable)
    {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 15, Sort.by("id").descending());
        return nBoardRepository.findAll(pageable);
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