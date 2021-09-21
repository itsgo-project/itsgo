package com.itsgo.mapstuct;

import com.itsgo.domain.board.BoardSuggest;
import com.itsgo.dto.BoardSuggestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface BoardSuggestMapper extends GenericMapper<BoardSuggestDto, BoardSuggest> {
}
