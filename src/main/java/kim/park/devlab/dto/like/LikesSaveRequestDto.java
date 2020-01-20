package kim.park.devlab.dto.like;

import kim.park.devlab.security.dto.SessionUser;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikesSaveRequestDto {

    private boolean likes;
    private Long postId;
    private SessionUser sessionUser;

    @Builder
    public LikesSaveRequestDto(boolean likes, Long postId, SessionUser sessionUser) {
        this.likes = likes;
        this.postId = postId;
        this.sessionUser = sessionUser;
    }
}
