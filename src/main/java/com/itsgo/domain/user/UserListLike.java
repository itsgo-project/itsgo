package com.itsgo.domain.user;

import com.itsgo.domain.board.Board;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class UserListLike {

    @EmbeddedId
    private UserListLikeId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @MapsId("boardId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", referencedColumnName = "board_id")
    private Board board;

    public UserListLike(User user, Board board) {
        this.user = user;
        this.board = board;
    }
}
