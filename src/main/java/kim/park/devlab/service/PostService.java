package kim.park.devlab.service;

import kim.park.devlab.domain.post.Post;
import kim.park.devlab.domain.post.PostRepository;
import kim.park.devlab.domain.user.User;
import kim.park.devlab.domain.user.UserRepository;
import kim.park.devlab.dto.post.*;
import kim.park.devlab.security.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public Long PostSaveRequest(PostSaveRequestDto dto, SessionUser sessionUser) {
        User user = userRepository.findByEmail(sessionUser.getEmail()).orElse(null);
        dto.setUser(user);
        return postRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    @ReadOnlyProperty
    public Page<PostFindAllResponseDto> PostFindAllResponse(Pageable pageable) {
        int page = pageable.getPageNumber() == 0 ? 0 : pageable.getPageNumber() - 1;
        pageable = PageRequest.of(page, 3);
        return postRepository.findAllPost(pageable);
    }

    public List<PostFindNotifyResponseDto> PostFindNotify() {
        List<PostFindNotifyResponseDto> notifies = postRepository.findNotify();
        return notifies.size() > 4 ? notifies.subList(0, 4) : notifies;
    }

    @Transactional
    public PostFindByIdResponseDto PostFindByIdResponse(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        return new PostFindByIdResponseDto(post);
    }

    @Transactional
    public Long PostUpdateRequestDto(PostUpdateRequestDto dto) {
        return postRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public void PostDeleteByIdRequest(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    @ReadOnlyProperty
    public List<String> PostFindDistinctCategoryResponse() {
        return postRepository.findDistinctCategory();
    }
}
