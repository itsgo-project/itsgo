package com.itsgo.service;

//@Service
//@RequiredArgsConstructor
//public class QBoardServiceImpl implements QBoardService
//{
//    final private QBoardRepository qBoardRepository;
//
//    public void makeData()
//    {
//        for(int i = 1; i <= 5; i++)
//        {
//            BoardSuggestDto qboard = new BoardSuggestDto();
//            qboard.setTitle("제목" + i);
//            qboard.setWrite("글쓴이" + i);
//            qboard.setContent("아무내용");
//            qBoardRepository.save(qboard);
//        }
//    }
//
//    @Override
//    public Page<BoardSuggestDto> getQBoardList(Pageable pageable)
//    {
//        int page= (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
//        pageable = PageRequest.of(page, 15, Sort.by("id").descending());
//
//        return qBoardRepository.findAll(pageable);
//    }
//
//    @Override
//    public void insertQBoard(BoardSuggestDto qBoard)
//    {
//        qBoardRepository.save(qBoard);
//    }
//
//    @Override
//    public BoardSuggestDto getQBoard(BoardSuggestDto qBoard)
//    {
//        return qBoardRepository.findById(qBoard.getId()).get();
//    }
//
//    @Override
//    public void updateQBoard(BoardSuggestDto qBoard)
//    {
//        BoardSuggestDto findQBoard = qBoardRepository.findById(qBoard.getId()).get();
//        System.out.println(qBoardRepository.findById(qBoard.getId()));
//        findQBoard.setTitle(qBoard.getTitle());
//        findQBoard.setContent(qBoard.getContent());
//        qBoardRepository.save(findQBoard);
//    }
//
//    @Override
//    public void deleteQBoard(BoardSuggestDto qBoard)
//    {
//        qBoardRepository.deleteById(qBoard.getId());
//    }
//}
