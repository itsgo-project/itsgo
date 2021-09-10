package com.itsgo.domain.board;

import lombok.Getter;
import org.hibernate.Hibernate;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Embeddable
public class StudyAcceptId implements Serializable {

    private Long userId;

    private Long boardId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudyAcceptId that = (StudyAcceptId) o;

        if (!Objects.equals(userId, that.userId)) return false;
        return Objects.equals(boardId, that.boardId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(userId);
        result = 31 * result + (Objects.hashCode(boardId));
        return result;
    }
}
