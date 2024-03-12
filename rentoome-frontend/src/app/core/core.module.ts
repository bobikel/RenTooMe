import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GetallComponent } from './components/properties/getall/getall.component';
import { BrowserModule } from '@angular/platform-browser';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    BrowserModule,
    MatGridListModule,
    MatCardModule
  ]
})
export class CoreModule { }
