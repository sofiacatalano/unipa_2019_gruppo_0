import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {Es2Component} from "./views/es2/es2.component";
import {IndexComponent} from "./views/index/index.component";
import {NotFoundComponent} from "./views/not-found/not-found.component";
import {ColorsComponent} from "./views/colors/colors.component";

const routes: Routes = [{
  path:'',
  component: Es2Component
},
  {
    path:'index',
    component: IndexComponent
  },
  {
    path:'colors',
    component: ColorsComponent
  },
  {
    path:'index/:nome',
    component: IndexComponent
  },{
    path:'**',
    component: NotFoundComponent
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
