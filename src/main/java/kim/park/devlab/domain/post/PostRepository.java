package kim.park.devlab.domain.post;

import kim.park.devlab.dto.post.PostFindAllResponseDto;
import kim.park.devlab.dto.post.PostFindNotifyResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p " +
            "from Post p " +
            "order by p.id desc ")
    Page<PostFindAllResponseDto> findAllPost(Pageable pageable);

    @Query("select distinct p.category " +
            "from Post p " +
            "where p.category not like 'Notify'" +
            "order by p.category asc ")
    List<String> findDistinctCategory();

    @Query("select p " +
            "from Post p " +
            "where p.category like 'Notify'" +
            "order by p.createdDate desc ")
    List<PostFindNotifyResponseDto> findNotify();
}
