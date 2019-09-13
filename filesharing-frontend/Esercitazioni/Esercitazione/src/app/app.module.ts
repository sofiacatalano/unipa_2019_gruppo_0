import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import { Es2Component } from './views/es2/es2.component';
import { IndexComponent } from './views/index/index.component';
import { NotFoundComponent } from './views/not-found/not-found.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { ColorsComponent } from './views/colors/colors.component';
import { FilterPipe } from './pipes/filter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    Es2Component,
    IndexComponent,
    NotFoundComponent,
    ColorsComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
