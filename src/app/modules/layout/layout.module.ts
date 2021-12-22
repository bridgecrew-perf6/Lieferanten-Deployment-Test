import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { FooterComponent } from './footer/footer.component';
import {RouterModule} from "@angular/router";
import {ZuliefererComponent} from "../../zulieferer/zulieferer.component";
import {ContactComponent} from "../../contact/contact.component";
import {HomeComponent} from "../../home/home.component";
import {DownloadComponent} from "../../download/download.component";
import {MiogaComponent} from "../../zulieferer/mioga/mioga.component";
import {EmkComponent} from "../../zulieferer/emk/emk.component";
import {ErrorComponent} from "../../error/error.component";



@NgModule({
  declarations: [
    NavbarComponent,
    SidebarComponent,
    FooterComponent
  ],
  imports: [
    CommonModule
    ,
    RouterModule.forRoot([
      {path:"", component:HomeComponent},
      {path:"home" , component:HomeComponent},
      {path: 'zulieferer', component: ZuliefererComponent},
      {path: 'contact', component:ContactComponent},
      {path: 'downloads' , component:DownloadComponent},
      {path: 'mioga' , component:MiogaComponent},
      {path: 'emk' , component:EmkComponent},
      {path: "**" , component:ErrorComponent}
    ]),

  ],
  exports: [
    NavbarComponent,
    SidebarComponent,
    FooterComponent
  ]
})
export class LayoutModule { }
