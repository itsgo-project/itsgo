package com.itsgo.domain.board;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@DynamicInsert
@DiscriminatorValue("Notice")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardNotice extends Board {

    @Builder
    public BoardNotice(String boardTitle, String boardContent)
    {
        super(boardTitle, boardContent);
    }

}
