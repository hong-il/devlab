package kim.park.devlab.domain.tag;

import kim.park.devlab.domain.BaseTimeEntity;
import kim.park.devlab.domain.post.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Tag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tag;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_TAG_POST"))
    private Post post;

    @Builder
    public Tag(String tag) {
        this.tag = tag;
    }
}
