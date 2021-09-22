package com.itsgo.domain.board;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@DynamicInsert
@DiscriminatorValue("STUDY")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardStudy extends Board {

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isStudyExpire;

    @Column(length = 255)
    private String studyApplicant;

    @Column(columnDefinition = "TINYINT UNSIGNED DEFAULT 0", nullable = false)
    private Integer studyMax;

    @OneToMany(mappedBy = "board")
    @Cascade(CascadeType.ALL)
    private List<StudyCategory> categoryList = new ArrayList<>();

    public void addCategoryList(StudyCategory category) {
        this.categoryList.add(category);
        category.setBoardStudy(this);
    }

    @Builder
    public BoardStudy(String boardTitle, String boardContent, Integer studyMax, Long id) {
        super(boardTitle, boardContent, id);
        this.studyMax = studyMax;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "createDate = " + getCreateDate() + ", " +
                "updateDate = " + getUpdateDate() + ", " +
                "boardTitle = " + getBoardTitle() + ", " +
                "boardHit = " + getBoardHit() + ", " +
                "boardContent = " + getBoardContent() + ", " +
                "boardLike = " + getBoardLike() + ", " +
                "createdBy = " + getCreatedBy() + ", " +
                "isStudyExpire = " + getIsStudyExpire() + ", " +
                "studyApplicant = " + getStudyApplicant() + ", " +
                "studyMax = " + getStudyMax() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BoardStudy that = (BoardStudy) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 1194311105;
    }
}
