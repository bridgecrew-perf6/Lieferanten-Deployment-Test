import {Component, OnInit} from '@angular/core';
import {Zulieferer} from "./zulieferer";
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpParams} from "@angular/common/http";
import {ZuliefererServices} from "./zulieferer.services";
import {FormArray, FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
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

  openContactForm = false;
  enableZuliefererButton = false
  activethisbutton = false
  Kontakthinzufgen = true;
  defaulttilte = "Ms";


  zuliefererForm: FormGroup;
  belongsTo = "Mioga";


  constructor(private zuliefererServices: ZuliefererServices) {
    this.zuliefererForm = new FormGroup({
      'title': new FormControl(null, Validators.required),
      'description': new FormControl(null, [Validators.required, Validators.email]),
      'belongsTo': new FormControl(null, Validators.required),
      'contacts': new FormArray([])
    })
  }

  AddContact() {

    const contact = new FormGroup({
      'title': new FormControl(null, Validators.required),
      'description': new FormControl(null, Validators.required),
      'company': new FormControl(null, Validators.required),
      'vorname': new FormControl(null, Validators.required),
      'name': new FormControl(null, Validators.required),
      'mobile': new FormControl(null, Validators.required),
      'email': new FormControl(null, [Validators.required, Validators.email]),
      'anmerkung': new FormControl(null)
    });
    (<FormArray>this.zuliefererForm.get('contacts')).push(contact);
    this.zuliefererForm.get('contacts')
  }

  getControls() {
    return (<FormArray>this.zuliefererForm.get('contacts')).controls;
  }

  get contacts()
  {
    return this.zuliefererForm.controls["contacts"] as FormArray
  }



  onAddzulieferer():void
  {
    console.log(JSON.stringify(this.zuliefererForm.value));

    this.zuliefererServices.createZulieferer(this.zuliefererForm.value).subscribe(
      (response: Zulieferer) => {
        console.log(response);
        this.getZulieferer();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }



  ngOnInit(): void {
    this.getZulieferer()
  }

  ContactForm(): void {
    this.openContactForm = true
    this.Kontakthinzufgen = false;
  }




/*
  onZuliefererAndContact(addZuliefererForm: NgForm): void {

    addZuliefererForm.value.contacts = this.zuliefercontactList

    console.log(JSON.stringify(addZuliefererForm.value.contacts))

    console.log(addZuliefererForm.value)

    this.zuliefererServices.createZulieferer(addZuliefererForm.value).subscribe(
      (response: Zulieferer) => {
        console.log(response);
        this.getZulieferer();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
    this.zuliefercontactList = []
    this.openContactForm = false;
    this.enableZuliefererButton = false
    this.activethisbutton = false
    this.Kontakthinzufgen = true;


  }


  onAddContact(addContactForm: NgForm): void {
    this.zuliefercontactList.push(addContactForm.value)
    this.enableZuliefererButton = true
    this.activethisbutton = true
  }
*/


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
