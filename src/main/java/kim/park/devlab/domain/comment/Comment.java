package kim.park.devlab.domain.comment;

import kim.park.devlab.domain.BaseTimeEntity;
import kim.park.devlab.domain.post.Post;
import kim.park.devlab.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_COMMENT_POST"))
    private Post post;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_COMMENT_USER"))
    private User user;

    @OneToMany(mappedBy = "comment", cascade = ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_COMMENT_COMMENT"))
    private Comment comment;

    @Builder
    public Comment(String content) {
        this.content = content;
    }
}
