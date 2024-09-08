package code.with.vanilson.fullstack.contact.service;

import code.with.vanilson.fullstack.contact.Contact;
import code.with.vanilson.fullstack.contact.ContactRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

import java.util.List;
import java.util.Optional;

/**
 * ContactService
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-09-07
 */
@BrowserCallable
@AnonymousAllowed
@SuppressWarnings("unused")
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    //create a list of contacts objects.
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    public Contact createContact(Contact contact) {
        if (null == contact) {
            throw new IllegalStateException(" contact cannot be null ");
        }
        return contactRepository.save(contact);
    }

    public Optional<Contact> getContactById(Long id) {
        var getContact = contactRepository.findById(id);
        if (getContact.isPresent()) {
            return getContact;
        }
        throw new IllegalStateException(" contact not found with id " + id);
    }

    public void updateContact(Contact contact) {
        if (null == contact) {
            throw new IllegalStateException(" contact cannot be null ");
        }
        //create new contact object here.
        Contact newContact = new Contact();
        newContact.setFirstName(contact.getFirstName());
        newContact.setLastName(contact.getLastName());
        newContact.setEmail(contact.getEmail());
        newContact.setPhoneNumber(contact.getPhoneNumber());
        contactRepository.save(newContact);

    }

    public void deleteContact(Long id) {
        var getContact = contactRepository.findById(id);
        if (getContact.isPresent()) {
            contactRepository.deleteById(id);
        }

    }

}