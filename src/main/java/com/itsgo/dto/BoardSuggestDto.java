package com.itsgo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BoardSuggestDto
{
    private Long id;
    private String boardTitle;
    private String boardContent;
    private String createdBy;
    private Integer boardHit;
    private LocalDateTime createDate;
//    0. 공개 1. 비공개
    private Integer suggestIsSecret;
//    0 미확인, 1 확인, 2 답변완료
    private Integer suggestProcessing;

}
