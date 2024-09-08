import Contact from "Frontend/generated/code/with/vanilson/fullstack/data/Contact";
import {useForm} from "@vaadin/hilla-react-form";
import ContactModel from "Frontend/generated/code/with/vanilson/fullstack/data/ContactModel";
import {Button, TextField} from "@vaadin/react-components";
import {useEffect} from "react";

interface ContactEditorProps {
    contact: Contact;
    onSubmit: (contact: Contact) => Promise<void>
}

export default function ContactEditor({contact, onSubmit}: ContactEditorProps) {

    const {field, model, submit, read} = useForm(ContactModel, {onSubmit})

    useEffect(() => {
        read(contact)
    }, [contact]);
    return (
        <div className="grid grid-cols-2 items-baseline">
            <TextField label="firstName"{...field(model.firstName)}/>
            <TextField label="lastName"{...field(model.lastName)}/>
            <TextField label="email"{...field(model.email)}/>
            <TextField label="phoneNumber"{...field(model.phoneNumber)}/>
            <Button onClick={submit} theme="primary">Save</Button>
        </div>
    );
}