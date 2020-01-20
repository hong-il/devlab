package kim.park.devlab.domain.post;

import kim.park.devlab.domain.BaseTimeEntity;
import kim.park.devlab.domain.comment.Comment;
import kim.park.devlab.domain.like.Likes;
import kim.park.devlab.domain.tag.Tag;
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
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String subtitle;

    @Column(nullable = false)
    private String category;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_POST_USER"))
    private User user;

    @OneToMany(mappedBy = "post", cascade = ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = ALL, fetch = FetchType.LAZY)
    private List<Tag> tags;

    @OneToMany(mappedBy = "post", cascade = ALL, fetch = FetchType.LAZY)
    private List<Likes> likes;

    @Builder
    public Post(String title, String subtitle, String category, String content, User user) {
        this.title = title;
        this.subtitle = subtitle;
        this.category = category;
        this.content = content;
        this.user = user;
    }
}
