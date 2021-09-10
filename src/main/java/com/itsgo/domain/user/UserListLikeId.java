package com.itsgo.domain.user;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserListLikeId implements Serializable {
    public String userId;
    public String boardId;
}
