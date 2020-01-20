package kim.park.devlab.domain.like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    @Query("select l " +
            "from Likes l " +
            "where l.post.id = ?1 " +
            "and l.user.id = ?2")
    Likes findByUser(Long postId, Long userId);
}
