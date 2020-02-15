package kim.park.devlab.web;

import kim.park.devlab.dto.comment.CommentSaveRequestDto;
import kim.park.devlab.security.dto.LoginUser;
import kim.park.devlab.security.dto.SessionUser;
import kim.park.devlab.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CommentRestController {

    private CommentService commentService;

    @PostMapping("/commentSave")
    public Long CommentSaveRequest(@RequestBody CommentSaveRequestDto dto, @LoginUser SessionUser sessionUser) {
        return commentService.CommentSaveRequest(dto, sessionUser);
    }
}
