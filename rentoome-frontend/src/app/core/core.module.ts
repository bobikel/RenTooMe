import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { Validators } from '@angular/forms';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    BrowserModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule,
    MatDividerModule,
    MatIconModule,
    MatDialogModule,
    FormControl,
    ReactiveFormsModule,
    Validators  
  ]
})
export class CoreModule { }
