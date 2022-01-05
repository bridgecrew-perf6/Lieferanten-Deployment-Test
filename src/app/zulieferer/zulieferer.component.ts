import {Component, OnInit, ViewChild} from '@angular/core';
import {Zulieferer} from "./zulieferer";
import {HttpErrorResponse} from "@angular/common/http";
import {ZuliefererServices} from "./zulieferer.services";
import {Contacts} from "../contact/contact";
import {FormArray, FormBuilder, Validators} from "@angular/forms";
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';


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
  defaulttilte = "Ms";
  belongsTo = "Mioga";
  control = false;





  zuliefererForm = this.fromBuilder.group({
    'title': ['', Validators.required],
    'description': ['',],
    'belongsTo': ['MIOGA', Validators.required],
    contacts : this.fromBuilder.array([])
  })


  constructor(private zuliefererServices: ZuliefererServices , private fromBuilder : FormBuilder , private modalService: NgbModal
  ) {}


  get contacts(){
    return this.zuliefererForm.controls["contacts"] as FormArray
  }



  get contactLenth(){
    return this.contacts.length
  }


  AddContact() {
    const contactForm = this.fromBuilder.group({
      'title': ['Ms' , Validators.required],
      'description':[''],
      'company': ['', Validators.required],
      'vorname':  [''],
      'name':  ['', Validators.required],
      'telefone':  ['', ],
      'mobile':  [''],
      'email': ['', Validators.required , Validators.email],
      'anmerkung':  ['']

    })
    this.contacts.push(contactForm);
  }
  deleteContact(ContactFromIndex : number) {
    this.contacts.removeAt(ContactFromIndex)
  }

  onAddzulieferer(): void {
    this.zuliefererServices.createZulieferer(this.zuliefererForm.value).subscribe(
      (response: Zulieferer) => {
        console.log(response);
        this.getZulieferer();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
    console.log(this.control)

  }



  ngOnInit(): void {
    this.getZulieferer()
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
