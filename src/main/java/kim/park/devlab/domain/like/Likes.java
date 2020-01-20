package kim.park.devlab.domain.like;

import kim.park.devlab.domain.BaseTimeEntity;
import kim.park.devlab.domain.user.User;
import kim.park.devlab.domain.post.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Likes extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean likes;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_LIKE_POST"))
    private Post post;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_LIKE_USER"))
    private User user;

    @Builder
    public Likes(boolean likes, Post post, User user) {
        this.likes = likes;
        this.post = post;
        this.user = user;
    }
}
