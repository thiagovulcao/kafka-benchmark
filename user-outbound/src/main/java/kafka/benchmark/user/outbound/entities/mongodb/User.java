package kafka.benchmark.user.outbound.entities.mongodb;

import kafka.benchmark.user.outbound.entities.enums.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@Document(collection = "user")
public class User {

    @Id
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
    @Indexed(unique = true)
    private String username;
    private Boolean isClustered;
    private LocalDateTime dateClustered;
}
