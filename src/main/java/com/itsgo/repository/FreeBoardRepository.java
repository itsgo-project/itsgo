package com.itsgo.repository;

import com.itsgo.dto.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long>
{
}
