package kim.park.devlab.web;

import kim.park.devlab.dto.post.PostFindAllResponseDto;
import kim.park.devlab.dto.post.PostFindByIdResponseDto;
import kim.park.devlab.dto.post.PostFindNotifyResponseDto;
import kim.park.devlab.security.dto.LoginUser;
import kim.park.devlab.security.dto.SessionUser;
import kim.park.devlab.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model, @PageableDefault Pageable pageable, @LoginUser SessionUser sessionUser) {

        if(sessionUser != null) {
            model.addAttribute("userName", sessionUser.getName());
            model.addAttribute("userEmail", sessionUser.getEmail());
            model.addAttribute("userPicture", sessionUser.getPicture());
        }

        Page<PostFindAllResponseDto> pages = postService.PostFindAllResponse(pageable);
        List<PostFindNotifyResponseDto> notifies = postService.PostFindNotify();
        model.addAttribute("pages", pages);
        model.addAttribute("notifies", notifies);

        int start = Math.max(1, pages.getNumber() - 2);
        int last = Math.min(start + 6, pages.getTotalPages());
        model.addAttribute("start", start);
        model.addAttribute("last", last);

        return "index";
    }

    @GetMapping("/post/{id}")
    public String post(Model model, @PathVariable("id") Long id) {
        PostFindByIdResponseDto post = postService.PostFindByIdResponse(id);
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/create")
    public String create(Model model, @LoginUser SessionUser user) {
        List<String> categories = postService.PostFindDistinctCategoryResponse();

        model.addAttribute("categories", categories);

        if(user != null) {
            model.addAttribute("user", user);
        }
        return "create";
    }
}
