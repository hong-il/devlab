package kim.park.devlab.web;

import kim.park.devlab.dto.post.PostSaveRequestDto;
import kim.park.devlab.security.dto.LoginUser;
import kim.park.devlab.security.dto.SessionUser;
import kim.park.devlab.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostRestController {

    private final PostService postService;

    @PostMapping("/save")
    public Long PostSaveRequest(@RequestBody PostSaveRequestDto dto, @LoginUser SessionUser sessionUser) {
        return postService.PostSaveRequest(dto, sessionUser);
    }

    /*@PostMapping("/find")
    public HeroFindByIdResponseDto HeroFindByIdResponse(@RequestBody Long id) {
        return heroService.HeroFindByIdResponse(id);
    }

    @PutMapping("/update")
    public Long HeroUpdateRequest(@RequestBody HeroUpdateRequestDto dto) {
        return heroService.HeroUpdateRequest(dto);
    }

    @DeleteMapping("/delete")
    public Long HeroDeleteByIdRequest(@RequestBody Long id) {
        heroService.HeroDeleteByIdRequest(id);
        return id;
    }*/
}
