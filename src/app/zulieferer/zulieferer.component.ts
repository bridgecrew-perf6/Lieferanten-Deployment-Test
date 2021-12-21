import {Component, OnInit} from '@angular/core';
import {Zulieferer} from "./zulieferer";
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpParams} from "@angular/common/http";
import {ZuliefererServices} from "./zulieferer.services";
import {NgForm} from "@angular/forms";
import {Contacts} from "../contact/contact";
import {ZuliefererObejct} from "./sendData";


@Component({
  selector: 'app-zulieferer',
  templateUrl: './zulieferer.component.html',
  styleUrls: ['./zulieferer.component.scss'],
})

export class ZuliefererComponent implements OnInit {

  zulieferer: Zulieferer[] = [];

  zuliefercontactList: Contacts[] = [];

  public editZulieferer: Zulieferer | undefined;
  public deleteZulieferer: Zulieferer | undefined;
  public showZuliefererContact: Zulieferer | undefined;




  constructor(private zuliefererServices: ZuliefererServices) {
  }

  ngOnInit(): void {
    this.getZulieferer()
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
  }



  onAddContact(addContactForm : NgForm) : void
  {
    this.zuliefercontactList.push(addContactForm.value)
  }


  public getZulieferer(): void {
    this.zuliefererServices.getAll().subscribe((receivedData) => (
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


}

//
// public onAddZulieferer(addZuliefererForm: NgForm): void {
//
//   // @ts-ignore
//   document.getElementById('add-zulieferer-form').click();
//
//   //passing the Values to the Backend
//   this.zuliefererServices.createZulieferer(addZuliefererForm.value).subscribe(
//     (response: Zulieferer) => {
//       console.log(response);
//       this.getZulieferer();
//     },
//     (error: HttpErrorResponse) => {
//       alert(error.message);
//     }
//   )
// }
