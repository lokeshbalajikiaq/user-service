package in.balu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer credentialId;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleBasedAuthority roleBasedAuthority;

    @JsonIgnore     //  Tells Jackson not to include this field in JSON output
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}
