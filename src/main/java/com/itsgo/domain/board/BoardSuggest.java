package com.itsgo.domain.board;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DynamicInsert
@DiscriminatorValue("Notice")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardSuggest extends Board
{
    //    0. 공개 1. 비공개
    private Integer suggestIsSecret;
    //    0 미확인, 1 확인, 2 답변완료
    @Column(insertable = false, updatable = false, columnDefinition = "tinyint default 0")
    private Integer suggestProcessing;

    @Builder
    public BoardSuggest(String boardTitle, String boardContent, Integer suggestIsSecret, Integer suggestProcessing, Long id)
    {
        super(boardTitle, boardContent, id);
        this.suggestIsSecret = suggestIsSecret;
        this.suggestProcessing = suggestProcessing;
    }

}
