package com.itsgo.dto;

import lombok.*;

@Builder
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BoardStudyDto {
    private String boardTitle;
    private String boardContent;
    private Integer studyMax;
}
