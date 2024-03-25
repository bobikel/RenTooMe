import { Component } from '@angular/core';
import { PropertiesService } from '../../../services/properties/properties.service';
import { Properties } from '../../../models/properties/properties';
import { NotificationService } from '../../../services/notifications/notifications.service';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogActions, MatDialogClose, MatDialogContent, MatDialogTitle } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-add',
  standalone: true,
  imports: [CommonModule, MatIconModule, 
    MatDialogActions, MatDialogClose,
     MatDialogTitle, MatDialogContent,
     FormsModule,
     ReactiveFormsModule],
  templateUrl: './add.component.html',
  styleUrl: './add.component.scss'
})
export class AddComponent {
  properties: Properties = new Properties();
  showModal: boolean = false;
  constructor(private propertyService: PropertiesService,
    private notificationService: NotificationService,
    private formBuilder: FormBuilder) { }

  propertyForm = this.formBuilder.group({
    libelle: ['', Validators.required],
    description: [''],
    // adresse: this.formBuilder.group({
    //   street: [''],
    //   city: [''],
    //   state: [''],
    //   zip: [''],
    // }),
    adresse: ['', Validators.required],
    occupationStatut: ['', Validators.required],
    propertyTypeDto: ['', Validators.required]
  });

  save() {
    const propertyData = {
      libelle: this.propertyForm.value.libelle,
      description: this.propertyForm.value.description,
      adresse: this.propertyForm.value.adresse,
      occupationStatut: this.propertyForm.value.occupationStatut,
      propertyTypeDto: this.propertyForm.value.propertyTypeDto
    };

    this.propertyService.addProperty(propertyData).subscribe(
      {
        next: (queryParams) => {
          console.log('success', queryParams);
          console.log("mon objet : ", propertyData)
        },

        error: (err: any) => {
          console.log('souscription incomplete : ', err)
        },
        complete: () => {
          console.log('subscription complete')
        }
      }
    );
    this.hideModal();
  }

  displayModal() {
    this.showModal = true;
  }

  hideModal() {
    this.showModal = false;
  }
}
