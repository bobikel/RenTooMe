import { CommonModule } from '@angular/common';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FooterComponent } from '../../footer/footer.component';
import { HeaderComponent } from '../../header/header.component';
import { PropertiesService } from '../../../services/properties/properties.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-getall',
  standalone: true,
  imports: [CommonModule, FooterComponent, HeaderComponent],
  templateUrl: './getall.component.html',
  styleUrl: './getall.component.css'
})
export class GetallComponent implements OnInit, OnDestroy {

  constructor(private propertyService: PropertiesService) {

  }

  datas: any;

  loading: boolean = true;

  ngOnInit(): void {
    this.getAllProperties();
  }


  async getAllProperties() {
    this.propertyService.getData()
      .subscribe((datas) => {
        this.datas = datas.data
        console.log("les datas :", datas.data)
      });
    console.log('just after subscribe');
  }

  ngOnDestroy(): void {
  }

}
