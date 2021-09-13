package com.itsgo.mapstuct;

import com.itsgo.domain.board.BoardNotice;
import com.itsgo.dto.BoardNoticeDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface BoardNoticeMapper extends GenericMapper<BoardNoticeDto, BoardNotice> {
}
