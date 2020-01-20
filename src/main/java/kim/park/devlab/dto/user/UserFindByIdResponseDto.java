package kim.park.devlab.dto.user;

import kim.park.devlab.domain.user.User;
import kim.park.devlab.domain.comment.Comment;
import kim.park.devlab.domain.like.Likes;
import kim.park.devlab.domain.post.Post;
import kim.park.devlab.domain.user.Role;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Getter
public class UserFindByIdResponseDto {

    private Long id;
    private String name;
    private String email;
    private String picture;
    private Role role;
    private List<Post> posts;
    private List<Comment> comments;
    private List<Likes> likes;
    private String createdDate;
    private String modifiedDate;

    public UserFindByIdResponseDto(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        picture = user.getPicture();
        role = user.getRole();
        posts = user.getPosts();
        comments = user.getComments();
        likes = user.getLikes();
        createdDate = toStringLocalDateTime(user.getCreatedDate());
        modifiedDate = toStringLocalDateTime(user.getModifiedDate());
    }

    public String toStringLocalDateTime(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(date)
                .map(formatter::format)
                .orElse("");
    }
}
