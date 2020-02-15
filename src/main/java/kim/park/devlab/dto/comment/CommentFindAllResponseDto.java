package kim.park.devlab.dto.comment;

import kim.park.devlab.domain.comment.Comment;
import kim.park.devlab.dto.user.UserFindByIdResponseDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;

@Getter
public class CommentFindAllResponseDto {

    private Long id;
    private String content;
    private Long postId;
    private UserFindByIdResponseDto user;
    private String createdDate;
    private String modifiedDate;

    public CommentFindAllResponseDto(Comment comment) {
        this.content = comment.getContent();
        this.postId = comment.getPost().getId();
        this.user = new UserFindByIdResponseDto(comment.getUser());
        this.createdDate = toStringLocalDateTime(comment.getCreatedDate());
        this.modifiedDate = toStringLocalDateTime(comment.getModifiedDate());
    }

    public String toStringLocalDateTime(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, YYYY HH:mm:ss", Locale.ENGLISH);
        return Optional.ofNullable(date)
                .map(formatter::format)
                .orElse("");
    }
}
