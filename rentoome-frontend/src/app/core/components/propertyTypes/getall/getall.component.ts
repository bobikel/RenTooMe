import { Component, OnInit, ViewChild } from '@angular/core';
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
import { MatTable, MatTableModule } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { ListDataSource, ListItem } from '../../properties/list/list-datasource';

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
    MatProgressSpinnerModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule
  ],
  templateUrl: './getall.component.html',
  styleUrl: './getall.component.scss'
})
export class GetallComponent implements OnInit {

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatTable) table!: MatTable<ListItem>;
  dataSource = new ListDataSource();

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['id', 'name'];

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
  }


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
