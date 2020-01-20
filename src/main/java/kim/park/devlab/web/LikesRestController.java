package kim.park.devlab.web;

import kim.park.devlab.security.dto.LoginUser;
import kim.park.devlab.security.dto.SessionUser;
import kim.park.devlab.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikesRestController {

    private final LikesService likesService;

    @PostMapping("/like/{postId}")
    public Long LikesSaveRequest(@PathVariable Long postId, @LoginUser SessionUser sessionUser) {
        return 1l;
    }
}
