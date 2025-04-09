import { Component, ElementRef, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {

  @ViewChild('navbar') navbarRef!: ElementRef;

  constructor(private renderer: Renderer2) { }

  toggleNavbar() {
    const hasClass = this.navbarRef.nativeElement.classList.contains('navbar-collapsed');
    if (hasClass) {
      this.renderer.removeClass(this.navbarRef.nativeElement, 'navbar-collapsed');
    } else {
      this.renderer.addClass(this.navbarRef.nativeElement, 'navbar-collapsed');
    }
  }

}
