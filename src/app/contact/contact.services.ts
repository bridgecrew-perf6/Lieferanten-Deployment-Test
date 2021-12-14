import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {Contacts} from "./contact";

@Injectable({providedIn: 'root'})

export class ContactServices {
  private apiServerUrl = environment.API_BASEURL

  constructor(private http: HttpClient) {
  }

  // Create a new Contact
  public createContact(contacts: Contacts): Observable<Contacts> {
    return this.http.post<Contacts>(`${this.apiServerUrl}/contacts/add`, contacts)
  }

  //Get all Contacts
  public getAll(): Observable<Contacts[]> {
    return this.http.get<Contacts[]>(`${this.apiServerUrl}/contacts/all`)
  }

  // Updating an Existing Contact
  public updateContact(contact: Contacts): Observable<Contacts> {
    return this.http.put<Contacts>(`${this.apiServerUrl}/contacts/update/`, contact)
  }

  //Find Contact By Id
  public getContactById(contactId: number): Observable<Contacts[]> {
    return this.http.get<Contacts[]>(`${this.apiServerUrl}/contacts/find/${contactId}`)
  }




  //Delete an contact
  public deleteContact(contactId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/contacts/delete/${contactId}`)
  }


}
