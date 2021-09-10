package com.itsgo.domain.board;

import com.itsgo.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
//@IdClass(StudyAcceptPK.class)
public class StudyAccept {

    /*
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardStudy board;
    */

    @EmbeddedId
    private StudyAcceptId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @MapsId("boardId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", referencedColumnName = "board_id")
    private BoardStudy board;


    @CreatedDate
    @Column(name = "study_appDate", updatable = false)
    private LocalDateTime appDate;

    @Column(name = "study_isAccept", columnDefinition = "TINYINT(1)")
    private Boolean isAccept;

    StudyAccept(User user, BoardStudy board, boolean isAccept) {
        this.user = user;
        this.board = board;
        this.isAccept = isAccept;
    }
}
