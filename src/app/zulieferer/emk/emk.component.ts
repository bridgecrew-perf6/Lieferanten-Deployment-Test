import { Component, OnInit } from '@angular/core';
import {Zulieferer} from "../zulieferer";
import {Contacts} from "../../contact/contact";
import {ZuliefererServices} from "../zulieferer.services";
import {NgForm} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-emk',
  templateUrl: './emk.component.html',
  styleUrls: ['./emk.component.scss']
})
export class EmkComponent implements OnInit {

  zulieferer: Zulieferer[] = [];

  zuliefercontactList: Contacts[] = [];

  public editZulieferer: Zulieferer | undefined;
  public deleteZulieferer: Zulieferer | undefined;
  public showZuliefererContact: Zulieferer | undefined;

  openContactForm = false;
  enableZuliefererButton = false
  activethisbutton = false
  Kontakthinzufgen = true;





  constructor(private zuliefererServices: ZuliefererServices) {
  }

  ngOnInit(): void {
    this.getZulieferer()
  }

  ContactForm() : void
  {
    this.openContactForm = true
    this.Kontakthinzufgen = false;
  }


  onZuliefererAndContact(addZuliefererForm: NgForm): void {

    addZuliefererForm.value.contacts = this.zuliefercontactList

    console.log(JSON.stringify(addZuliefererForm.value.contacts))

    console.log(addZuliefererForm.value)

    this.zuliefererServices.createZulieferer(addZuliefererForm.value).subscribe(
      (response:Zulieferer)=>{
        console.log(response);
        this.getZulieferer();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
    this.zuliefercontactList = []
    this.openContactForm = false;
    this.enableZuliefererButton = false
    this.activethisbutton = false
    this.Kontakthinzufgen = true;



  }



  onAddContact(addContactForm : NgForm) : void
  {
    this.zuliefercontactList.push(addContactForm.value)
    this.enableZuliefererButton = true
    this.activethisbutton = true
  }


  public getZulieferer(): void {
    this.zuliefererServices.getEmkZulieferer().subscribe((receivedData) => (
      this.zulieferer = receivedData)
    );
  }

  public getZuliefererContacts(zulieferer: any): void {

    this.showZuliefererContact = zulieferer;
    console.log("Zulieferer ID " + zulieferer.id)

    this.zuliefererServices.getZuliefererContactsById(zulieferer.id).subscribe((receivedData) => (
      this.zuliefercontactList = receivedData)
    );
  }


  public onUpdateZulieferer(updateZulieferer: Zulieferer): void {
    this.zuliefererServices.updateZulieferer(updateZulieferer).subscribe(
      (response: Zulieferer) => {
        console.log(response);
        this.getZulieferer();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  public onDeleteZulieferer(zulieferId: any): void {
    this.zuliefererServices.deleteZulieferer(zulieferId).subscribe(
      (response: void) => {
        console.log(response);
        this.getZulieferer();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }







}
