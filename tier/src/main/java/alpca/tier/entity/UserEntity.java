package alpca.tier.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class UserEntity {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private String role;
    private String gender;

}
