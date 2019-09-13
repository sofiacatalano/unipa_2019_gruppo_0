import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './views/dashboard/dashboard.component';
import {RegistrationComponent} from "./views/registration/registration.component";
import {LoginComponent} from "./views/login/login.component";
import {TeamsComponent} from "./views/teams/teams.component";
import {BucketsComponent} from "./views/buckets/buckets.component";
import {BucketDetailComponent} from "./views/bucket-detail/bucket-detail.component";
import {FoldersComponent} from "./views/folders/folders.component";

const routes: Routes = [
  {
    path:'login',
    component: LoginComponent
  },
  {
    path:'registration',
    component: RegistrationComponent
  },
  {
    path:'',
    component: DashboardComponent,
    children:[
      {
        path:'',
        component:TeamsComponent
      },
      {
        path:':team',
        component:BucketsComponent,
      },
      {
        path:':team/:bucket',
        children:[
          {
            path:'**',
            component:BucketDetailComponent
          },
        ]
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
