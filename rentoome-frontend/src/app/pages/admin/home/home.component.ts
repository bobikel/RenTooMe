import { Component } from '@angular/core';
import { MenuComponent } from '../../../feature/shared/menu/menu.component';
import { HeaderComponent } from '../../../feature/shared/header/header.component';
import { LoaderComponent } from "../../../feature/shared/loader/loader.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MenuComponent, HeaderComponent, LoaderComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
