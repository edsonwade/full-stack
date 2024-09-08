package code.with.vanilson.fullstack.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * ContactRepository
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-09-07
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>,
                                           JpaSpecificationExecutor<Contact> {
}
