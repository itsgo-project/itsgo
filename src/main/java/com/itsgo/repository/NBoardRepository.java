package com.itsgo.repository;

import com.itsgo.dto.NBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NBoardRepository extends JpaRepository<NBoard, Long>
{
}
