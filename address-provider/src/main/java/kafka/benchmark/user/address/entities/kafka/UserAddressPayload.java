package kafka.benchmark.user.address.entities.kafka;

import kafka.benchmark.user.address.entities.enums.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@ToString
public class UserAddressPayload {

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
    @Valid
    @Setter
    private List<AddressPayload> addresses = new ArrayList<>();


    @Getter
    @Builder
    @ToString
    public static class AddressPayload {

        @NotNull
        private Long id;
        @NotEmpty
        private String country;
        @NotEmpty
        private String state;
        @NotEmpty
        private String city;
        @NotEmpty
        private String postalCode;
        @NotEmpty
        private String street;
        @NotEmpty
        private String streetNumber;
    }
}
