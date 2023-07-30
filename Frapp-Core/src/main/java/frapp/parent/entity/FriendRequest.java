package frapp.parent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_request")
@IdClass(FriendRequestId.class)
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_ıd", nullable = false)
    private UUID requestId;
    @Id
    private UUID sendingUser;
    @Id
    private UUID targetUser;
    private String requestStatus;
    private Timestamp requestTime;
}

@NoArgsConstructor
@AllArgsConstructor
 class FriendRequestId implements Serializable {
    private UUID sendingUser;
    private UUID targetUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FriendRequestId)) return false;
        FriendRequestId that = (FriendRequestId) o;
        return sendingUser.equals(that.sendingUser) && targetUser.equals(that.targetUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sendingUser, targetUser);
    }
}