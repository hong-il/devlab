package kim.park.devlab.service;

import kim.park.devlab.domain.comment.CommentRepository;
import kim.park.devlab.domain.post.Post;
import kim.park.devlab.domain.post.PostRepository;
import kim.park.devlab.domain.user.User;
import kim.park.devlab.domain.user.UserRepository;
import kim.park.devlab.dto.comment.CommentSaveRequestDto;
import kim.park.devlab.security.dto.SessionUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private UserRepository userRepository;

    @Transactional
    public Long CommentSaveRequest(CommentSaveRequestDto dto, SessionUser sessionUser) {
        Post post = postRepository.findById(dto.getPostId()).orElse(null);
        User user = userRepository.findByEmail(sessionUser.getEmail()).orElse(null);

        dto.setPost(post);
        dto.setUser(user);

        return commentRepository.save(dto.toEntity()).getId();
    }
}
