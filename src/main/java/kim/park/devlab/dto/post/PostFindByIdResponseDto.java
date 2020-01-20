package kim.park.devlab.dto.post;

import kim.park.devlab.domain.user.User;
import kim.park.devlab.domain.comment.Comment;
import kim.park.devlab.domain.like.Likes;
import kim.park.devlab.domain.post.Post;
import kim.park.devlab.domain.tag.Tag;
import kim.park.devlab.dto.user.UserFindByIdResponseDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Getter
public class PostFindByIdResponseDto {

    private Long id;
    private String title;
    private String subtitle;
    private String category;
    private String content;
    private User user;
    private List<Comment> comments;
    private List<Likes> likes;
    private List<Tag> tags;
    private String createdDate;
    private String modifiedDate;

    public PostFindByIdResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.subtitle = post.getSubtitle();
        this.category = post.getCategory();
        this.content = post.getContent();
        this.user = post.getUser();
        this.comments = post.getComments();
        this.likes = post.getLikes();
        this.tags = post.getTags();
        this.createdDate = toStringLocalDateTime(post.getCreatedDate());
        this.modifiedDate = toStringLocalDateTime(post.getModifiedDate());
    }

    public String toStringLocalDateTime(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM D, YYYY", Locale.ENGLISH);
        return Optional.ofNullable(date)
                .map(formatter::format)
                .orElse("");
    }
}
