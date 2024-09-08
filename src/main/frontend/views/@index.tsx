import '../styles/styles.css';
import {AutoCrud} from "@vaadin/hilla-react-crud";
import {ContactService, ContactServiceImpl} from "Frontend/generated/endpoints";
import ContactModel from "./Frontend/generated/code/with/vanilson/fullstack/data/ContactModel";
import React from "react";

export default function ContactView() {

     // // * First way of implementing using ContactService
     // const [contacts, setContacts] = useState<Contact[]>([])
     // const [selected, setSelected] = useState<Contact | null>();
     // // Fetch contact on component
     // useEffect(() => {
     // ContactService.getContacts().then(setContacts)
     //
     // }, []);
     //
     // async function onSubmit(contact: Contact) {
     // const updated = await ContactService.createContact(contact);
     // setContacts(contacts.map(contact => contact.id === updated.id ? updated : contact));
     //
     // }
     //
     //
     // return (
     // <div className="p-m">
     // <h1>Contact</h1>
     // <Grid
     // items={contacts}
     // onActiveItemChanged={(e) => setSelected(e.detail.value)}
     // selectedItems={selected ? [selected] : []}
     // >
     // <GridColumn path="firstName"/>
     // <GridColumn path="lastName"/>
     // <GridColumn path="email"/>
     // <GridColumn path="phoneNumber"/>
     // </Grid>
     //
     // {selected && <ContactEditor contact={selected} onSubmit={onSubmit}/>}
     // </div>
     // );


    return <AutoCrud service={ContactServiceImpl} model={ContactModel} className="h-full"/>
}