package code.with.vanilson.fullstack.contact;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Contact
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-09-07
 */
@Entity
@Table(name = "contacts")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonPropertyOrder(value = {"id", "firstName", "lastName", "email", "phoneNumber"})
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    @Email
    private String email;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    // create constructor
    public Contact(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}