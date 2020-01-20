package kim.park.devlab.dto.like;

import kim.park.devlab.domain.like.Likes;
import kim.park.devlab.domain.user.User;
import kim.park.devlab.domain.post.Post;
import lombok.Getter;

@Getter
public class LikesFindByIdResponseDto {

    private Long id;
    private boolean likes;
    private Post post;
    private User user;

    public LikesFindByIdResponseDto(Likes likes) {
        this.id = likes.getId();
        this.likes = likes.isLikes();
        this.post = likes.getPost();
        this.user = likes.getUser();
    }
}
