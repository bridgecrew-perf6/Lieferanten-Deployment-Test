import {Component, OnInit} from '@angular/core';
import {Zulieferer} from "./zulieferer";
import {HttpErrorResponse} from "@angular/common/http";
import {ZuliefererServices} from "./zulieferer.services";
import {NgForm} from "@angular/forms";
import {Contacts} from "../contact/contact";


@Component({
  selector: 'app-zulieferer',
  templateUrl: './zulieferer.component.html',
  styleUrls: ['./zulieferer.component.scss'],
})

export class ZuliefererComponent implements OnInit {

  zulieferer: Zulieferer[] = [];
  zuliefercontactList: Contacts[] = [];


  showContactButton = false;

  public editZulieferer: Zulieferer | undefined;
  public deleteZulieferer: Zulieferer | undefined;
  public showZuliefererContact : Zulieferer | undefined;
  contacts = new Map<number, Contacts[]>();


  isActiveTwo = false;
  isActiveOne = true;

  constructor(private zuliefererServices: ZuliefererServices) {
  }

  ngOnInit(): void {
    this.getZulieferer()
    console.log("The List Zulieferer List 2  ngOnInit() " + this.zulieferer.length);
  }


  public getZulieferer(): void {
    this.zuliefererServices.getAll().subscribe((receivedData) => (
      this.zulieferer = receivedData)
    );

    console.log("The List Zulieferer List 1 getZulieferer() " + this.zulieferer.length);
  }

  public getZuliefererContacts(zulieferer: any): void {

    this.showZuliefererContact= zulieferer;
    console.log("Zulieferer ID " + zulieferer.id)

    this.zuliefererServices.getZuliefererContactsById(zulieferer.id).subscribe((receivedData) => (
      this.zuliefercontactList = receivedData)
    );
    if (!this.showContactButton )
    {
      this.showContactButton =true
    }
  }


  public getandSaveZulieferer(): number {
    return 0;
  }

  public updateContactsList() {
    this.zulieferer.forEach((zulieferer) => {
        this.contacts.set(zulieferer.id, zulieferer.contacts)
      }
    )
  }


  public getcurrentContactlist(id: number): any {
    return this.contacts.get(id);
  }


  public printmap() {

    console.log("inside the print button" + this.contacts.size)
    this.contacts.forEach((value: Contacts[], key: number) => {
      console.log("________________________" + key, value)
    });


  }


  public onAddZulieferer(addZuliefererForm: NgForm): void {

    // @ts-ignore
    document.getElementById('add-zulieferer-form').click();

    //passing the Values to the Backend
    this.zuliefererServices.createZulieferer(addZuliefererForm.value).subscribe(
      (response: Zulieferer) => {
        console.log(response);
        this.getZulieferer();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
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


  public onOpenModal(zulieferer: any, mode: string): void {

    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addZuliefererModal');
    }
    if (mode === 'edit') {
      this.editZulieferer = zulieferer;
      button.setAttribute('data-target', '#updateZuliefererModal');
    }
    if (mode === 'delete') {
      this.deleteZulieferer = zulieferer;
      button.setAttribute('data-target', '#deleteZulieferereModal');
    }
    if (mode === 'showContact') {
      button.setAttribute('data-target', "#zulieferContact")
    }

    // @ts-ignore
    container.appendChild(button);
    button.click();
  }

  // Pass The Argument to another Component


  onAddContact(addContactForm: any) {
    // @ts-ignore
    this.contactComponent.on(addContactForm);
  }

}
