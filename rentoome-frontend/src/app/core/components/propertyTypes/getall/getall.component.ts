import { Component, OnInit } from '@angular/core';
import { PropertyTypesService } from '../../../services/propertyTypes/propertyTypes.service';
import { IPropertyType } from '../../../interfaces/propertyType/i-property-type';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { inject } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { AsyncPipe, CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { NotificationService } from '../../../services/notifications/notifications.service';

@Component({
  selector: 'app-getall',
  standalone: true,
  imports: [CommonModule,
    MatGridListModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    AsyncPipe,
    MatCardModule,
    MatProgressSpinnerModule
  ],
  templateUrl: './getall.component.html',
  styleUrl: './getall.component.scss'
})
export class GetallComponent implements OnInit {
  ipropertyType: IPropertyType | undefined;
  headers: string[] = [];

  gridData: any[] = [];
  message: string = '';
  status: number | undefined;
  isLoading: boolean = true;

  private breakpointObserver = inject(BreakpointObserver);

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private propertyTypeService: PropertyTypesService, private notificationService: NotificationService) {
  }
  ngOnInit(): void {
    this.getAllProperties();
  }

  getAllProperties() {
    this.propertyTypeService.getData()
      .subscribe(data => {
        this.gridData = data.data; // Assignez les données à gridData
        this.message = data.message; // Assignez le message
        this.status = data.status; // Assignez le 
        this.isLoading = false; // Masque le spinner une fois les données chargées
        this.notificationService.success(this.message);
      });

  }
}
