package com.itsgo.repository;

import com.itsgo.domain.board.Board;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BoardRepository<T extends Board> extends JpaRepository<T, Long> {

//    @Bean
//    @Query("UPDATE boardBasic SET boardHit = boardHit + 1")
//    void upHit();

}
