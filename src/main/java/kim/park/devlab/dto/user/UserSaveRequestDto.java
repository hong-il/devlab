package kim.park.devlab.dto.user;

import kim.park.devlab.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserSaveRequestDto {

    private String name;
    private String email;
    private String picture;

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .build();
    }
}
