package kim.park.devlab.dto.post;

import kim.park.devlab.domain.post.Post;
import kim.park.devlab.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PostSaveRequestDto {

    private String title;
    private String subtitle;
    private String category;
    private String content;
    private User user;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .subtitle(subtitle)
                .category(category)
                .content(content)
                .user(user)
                .build();
    }
}
