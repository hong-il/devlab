package kim.park.devlab.dto.post;

import kim.park.devlab.domain.post.Post;
import kim.park.devlab.dto.user.UserFindByIdResponseDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;

@Getter
public class PostFindNotifyResponseDto {

    private Long id;
    private String title;
    private String category;
    private UserFindByIdResponseDto user;
    private String createdDate;

    public PostFindNotifyResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.category = post.getCategory();
        this.user = new UserFindByIdResponseDto(post.getUser());
        this.createdDate = toStringLocalDateTime(post.getCreatedDate());
    }

    public String toStringLocalDateTime(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, YYYY", Locale.ENGLISH);
        return Optional.ofNullable(date)
                .map(formatter::format)
                .orElse("");
    }
}
