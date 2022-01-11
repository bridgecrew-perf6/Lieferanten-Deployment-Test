
package mioga.services;

import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.property.StructuredName;
import mioga.entites.Contacts;
import mioga.repositories.ContactRepository;
import mioga.utility.SFWhere;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class ContactService {
    private static final Logger LOGGER = Logger.getLogger(ContactService.class.getName());
    @Autowired
    ContactRepository contactRepository;

    public ResponseEntity<Object> search(Contacts contact, Pageable pageable) {
        Page<Contacts> all = contactRepository.findAll(SFWhere.and(contact)
                .build(), pageable);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    public Contacts save(Contacts contact) {

        List<Contacts> entityList = contactRepository.findAll();

        if (contact.getCompany() == null) {
            LOGGER.log(Level.SEVERE,
                    "Contacts is null. Are you sure you have connected your form to the application?");
        } else if (!entityList.contains(contact)) {

            return contactRepository.save(contact);
        }
        return null;
    }

    public List<Contacts> findAll() {
        return contactRepository.findAll();
    }

    public void deleteById(int id) {
        contactRepository.deleteById(id);
    }


    public Contacts update(Contacts newContact) {


        return contactRepository.save(newContact);


    }


    public String findById(int id) {

        Contacts contacts = contactRepository.findById(id);
        VCard vCard = new VCard();
        StructuredName name = new StructuredName();
        name.setFamily(contacts.getName());
        name.setGiven(contacts.getVorname());

        vCard.setStructuredName(name);
        vCard.addTitle(String.valueOf(contacts.getTitle()));


        vCard.addTelephoneNumber(contacts.getTelefone());
        vCard.addEmail(contacts.getEmail());
        vCard.setOrganization(contacts.getCompany());


        String str = Ezvcard.write(vCard).version(VCardVersion.V4_0).go();


        return str;
    }



}






