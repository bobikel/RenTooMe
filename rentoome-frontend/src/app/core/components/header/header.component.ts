import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  displayDropdownMenu: boolean = false;

  constructor() {

  }

  showMenu() {
    this.displayDropdownMenu = !this.displayDropdownMenu;
    console.log("le display : " +this.displayDropdownMenu);
  }
}
