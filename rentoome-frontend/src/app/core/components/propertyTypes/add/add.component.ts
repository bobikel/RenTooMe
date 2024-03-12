import { Component } from '@angular/core';
import { PropertyTypesService } from '../../../services/propertyTypes/propertyTypes.service';

@Component({
  selector: 'app-add',
  standalone: true,
  imports: [],
  templateUrl: './add.component.html',
  styleUrl: './add.component.scss'
})
export class AddComponent {

  constructor(private propertyTypeService: PropertyTypesService) {

  }

}
