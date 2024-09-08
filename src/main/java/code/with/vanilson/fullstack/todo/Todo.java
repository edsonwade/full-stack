package code.with.vanilson.fullstack.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * Todo
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-09-08
 */
@Entity
@Getter
@Setter
@Service
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task;
    private boolean done;

    public Todo() {
        // default constructor
    }

    // Construct
    public Todo(String task) {
        this.task = task;
    }

}