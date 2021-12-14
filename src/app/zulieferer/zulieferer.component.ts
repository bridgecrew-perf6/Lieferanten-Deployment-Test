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
  public zulieferer: Zulieferer[] = [];
  public editZulieferer: Zulieferer | undefined;
  public deleteZulieferer: Zulieferer | undefined;
  contacts = new Map<number, Contacts[]>();

  isActive = false;

  constructor(private zuliefererServices: ZuliefererServices) {
  }

  ngOnInit(): void {
    this.getZulieferer()
    this.updateContactsList()
    this.printmap()
  }


  public getZulieferer(): void {
    this.zuliefererServices.getAll().subscribe(
      (response: Zulieferer[]) => {
        this.zulieferer = response;
        this.updateContactsList()

      },
    )
  }

  public updateContactsList()
  {
    this.zulieferer.forEach((zulieferer) => {
        this.contacts.set(zulieferer.id, zulieferer.contacts)
      }
    )
  }





  public getcurrentContactlist(id: number): any {
    return this.contacts.get(id);
  }



  public printmap() {
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
    if (mode === 'Contact') {
      button.setAttribute('data-target', "zulieferContact")
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
