package code.with.vanilson.fullstack.contact;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * DbInit
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-09-07
 */
@Component
public class DbInit implements ApplicationRunner {

    private final ContactRepository contactRepository;
    private final Random random = new Random();

    public DbInit(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

// List of 20 first names
        List<String> firstNames = List.of("John", "Jane", "Michael", "Emily", "Chris", "Sophia",
                "David", "Olivia", "Daniel", "Ava", "James", "Isabella",
                "Matthew", "Mia", "Andrew", "Charlotte", "Lucas", "Amelia",
                "Henry", "Evelyn");

        // List of 20 last names
        List<String> lastNames = List.of("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia",
                "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez",
                "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas",
                "Taylor", "Moore", "Jackson", "Martin");
        List<Contact> contacts = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            // Randomly select first and last name
            String firstName = firstNames.get(random.nextInt(firstNames.size()));
            String lastName = lastNames.get(random.nextInt(lastNames.size()));

            // Generate a unique email
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + i + "@example.com";

            // Generate a random phone number
            String phoneNumber = String.format("555-%03d-%04d", random.nextInt(1000), random.nextInt(10000));

            // Create a new Contact
            Contact contact = new Contact(firstName, lastName, email, phoneNumber);
            contacts.add(contact);
        }

        // Save all contacts to the database
        contactRepository.saveAll(contacts);

    }

}