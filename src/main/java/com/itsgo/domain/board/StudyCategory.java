package com.itsgo.domain.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
public class StudyCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "INT(11) UNSIGNED")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardStudy board;

    private String studyDev;

    private String studyArea;

    public void setBoardStudy(BoardStudy board) {
        this.board = board;
    }

    public StudyCategory(String studyDev, String studyArea) {
        this.studyDev = studyDev;
        this.studyArea = studyArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudyCategory that = (StudyCategory) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 576034242;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "studyDev = " + studyDev + ", " +
                "studyArea = " + studyArea + ")";
    }
}


