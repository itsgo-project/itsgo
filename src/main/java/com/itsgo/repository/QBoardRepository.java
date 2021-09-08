package com.itsgo.repository;

import com.itsgo.dto.QBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QBoardRepository extends JpaRepository<QBoard, Long>
{
}
