package kim.park.devlab.dto.post;

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
public class PostFindAllResponseDto {

    private Long id;
    private String title;
    private String subtitle;
    private String category;
    private String content;
    private UserFindByIdResponseDto user;
    private int commentsSize;
    private int likesSize;
    private List<Tag> tags;
    private String createdDate;
    private String modifiedDate;

    public PostFindAllResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.subtitle = post.getSubtitle();
        this.category = post.getCategory();
        this.content = post.getContent();
        this.user = new UserFindByIdResponseDto(post.getUser());
        this.commentsSize = post.getComments().size();
        this.likesSize = post.getLikes().size();
        this.tags = post.getTags();
        this.createdDate = toStringLocalDateTime(post.getCreatedDate());
        this.modifiedDate = toStringLocalDateTime(post.getModifiedDate());
    }

    public String toStringLocalDateTime(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, YYYY", Locale.ENGLISH);
        return Optional.ofNullable(date)
                .map(formatter::format)
                .orElse("");
    }
}
