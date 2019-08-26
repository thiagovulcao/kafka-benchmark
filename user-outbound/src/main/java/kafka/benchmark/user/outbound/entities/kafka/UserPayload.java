package kafka.benchmark.user.outbound.entities.kafka;

import kafka.benchmark.user.outbound.entities.enums.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class UserPayload {

    @NotNull
    private String id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email
    @NotEmpty
    private String email;
    @NotNull
    private Gender gender;
    @NotEmpty
    private String ipAddress;
    private String avatar;
    private String race;
    @NotEmpty
    private String username;
    private Boolean isClustered;
    private LocalDateTime dateClustered;
}
