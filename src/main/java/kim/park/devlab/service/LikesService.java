package kim.park.devlab.service;

import kim.park.devlab.domain.like.Likes;
import kim.park.devlab.domain.like.LikesRepository;
import kim.park.devlab.domain.user.UserRepository;
import kim.park.devlab.dto.like.LikesSaveRequestDto;
import kim.park.devlab.security.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LikesService {

    private final UserRepository userRepository;
    private final LikesRepository likesRepository;

    @Transactional
    public Long LikesSaveRequest(LikesSaveRequestDto dto) {
        return 1l;
    }


    @Transactional
    @ReadOnlyProperty
    public boolean IsLikesResponse(Long postId, SessionUser sessionUser) {
        Long userId = userRepository.findByEmail(sessionUser.getEmail()).orElse(null).getId();
        Likes likes = likesRepository.findByUser(postId, userId);
        if (likes != null) likes.isLikes();
        return false;
    }
}
