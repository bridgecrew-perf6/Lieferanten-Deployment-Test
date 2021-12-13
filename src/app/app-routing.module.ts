import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ZuliefererComponent} from "./zulieferer/zulieferer.component";
import {AppComponent} from "./app.component";

const routes: Routes = [
  {path: 'zulieferer', component: ZuliefererComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
