import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LayoutModule} from "./modules/layout/layout.module";
import {ZuliefererComponent} from './zulieferer/zulieferer.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { ContactComponent } from './contact/contact.component';
import {VarDirective} from "./zulieferer/ng-var.directive";
import { HomeComponent } from './home/home.component';



@NgModule({
  declarations: [
    AppComponent,
    ZuliefererComponent,
    ContactComponent,
    VarDirective,
    HomeComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    LayoutModule,
    FormsModule,
    HttpClientModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
