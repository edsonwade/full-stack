package code.with.vanilson.fullstack.contact.service;

import code.with.vanilson.fullstack.contact.Contact;
import code.with.vanilson.fullstack.contact.ContactRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.crud.CrudRepositoryService;

/**
 * ContactServiceImpl
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-09-07
 */
@BrowserCallable
@AnonymousAllowed
public class ContactServiceImpl extends CrudRepositoryService<Contact, Long, ContactRepository> {
}