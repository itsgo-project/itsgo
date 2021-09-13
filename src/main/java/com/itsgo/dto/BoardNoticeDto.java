package com.itsgo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BoardNoticeDto
{
    private String boardTitle;
    private String boardContent;
    private String createdBy;
    private LocalDateTime createDate;
    private Integer boardHit;
}
