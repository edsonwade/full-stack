import { EndpointRequestInit as EndpointRequestInit_1 } from "@vaadin/hilla-frontend";
import type Contact_1 from "./code/with/vanilson/fullstack/contact/Contact.js";
import client_1 from "./connect-client.default.js";
async function createContact_1(contact: Contact_1, init?: EndpointRequestInit_1): Promise<Contact_1> { return client_1.call("ContactService", "createContact", { contact }, init); }
async function deleteContact_1(id: number, init?: EndpointRequestInit_1): Promise<void> { return client_1.call("ContactService", "deleteContact", { id }, init); }
async function getContactById_1(id: number, init?: EndpointRequestInit_1): Promise<Contact_1 | undefined> { return client_1.call("ContactService", "getContactById", { id }, init); }
async function getContacts_1(init?: EndpointRequestInit_1): Promise<Array<Contact_1>> { return client_1.call("ContactService", "getContacts", {}, init); }
async function updateContact_1(contact: Contact_1, init?: EndpointRequestInit_1): Promise<void> { return client_1.call("ContactService", "updateContact", { contact }, init); }
export { createContact_1 as createContact, deleteContact_1 as deleteContact, getContactById_1 as getContactById, getContacts_1 as getContacts, updateContact_1 as updateContact };
