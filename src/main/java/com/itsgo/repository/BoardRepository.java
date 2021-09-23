package com.itsgo.repository;

import com.itsgo.domain.board.Board;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BoardRepository<T extends Board> extends JpaRepository<T, Long> {

    @Bean
    @Modifying
    @Query(value = "update board_basic set board_hit = board_hit + 1 where board_id=:id",nativeQuery = true)
    void upHit(Long id);

}
