package code.with.vanilson.fullstack.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TodoRepo
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-09-08
 */
@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {
}