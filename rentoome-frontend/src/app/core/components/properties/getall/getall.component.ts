import { Component } from '@angular/core';
import { PropertiesService } from '../../../services/properties/properties.service';
import { Iproperty } from '../../../interfaces/property/iproperty';

@Component({
  selector: 'app-getall',
  standalone: true,
  imports: [],
  templateUrl: './getall.component.html',
  styleUrl: './getall.component.scss'
})
export class GetallComponent {

  iProperties: Iproperty | undefined;

  constructor(private propertiesService: PropertiesService) {
  }
  getAllProperties() {
    this.propertiesService.getData()
      .subscribe(data => this.iProperties = {
        libelle: data.libelle,
        description: data.description,
        adresse: data.adresse,
        occupationStatut: data.occupationStatut,
        propertyType: data.propertyType
      });
  }
}
