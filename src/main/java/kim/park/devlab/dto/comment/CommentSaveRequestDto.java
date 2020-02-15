package kim.park.devlab.dto.comment;

import kim.park.devlab.domain.comment.Comment;
import kim.park.devlab.domain.post.Post;
import kim.park.devlab.domain.user.User;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentSaveRequestDto {

    private String content;
    private Long postId;
    private Post post;
    private User user;

    public Comment toEntity() {
        return Comment.builder()
                .content(content)
                .post(post)
                .user(user)
                .build();
    }
}
