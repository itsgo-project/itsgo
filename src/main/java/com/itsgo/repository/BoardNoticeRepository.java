package com.itsgo.repository;


import com.itsgo.domain.board.BoardNotice;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;

public interface BoardNoticeRepository extends BoardRepository<BoardNotice> {

}
