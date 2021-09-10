package com.itsgo.repository;

import com.itsgo.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BoardRepository<T extends Board> extends JpaRepository<T, Long> {

}
