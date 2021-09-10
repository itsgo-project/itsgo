package com.itsgo.mapstuct;

import com.itsgo.domain.board.BoardStudy;
import com.itsgo.dto.BoardStudyDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface BoardStudyMapper extends GenericMapper<BoardStudyDto, BoardStudy> {
}
