import { Routes } from '@angular/router';
import { GetallComponent } from './core/components/propertyTypes/getall/getall.component';
import { ListComponent } from './core/components/properties/list/list.component';
import { DashboardComponent } from './layout/admin/dashboard/dashboard.component';

export const routes: Routes = [
    {
        path: '',
        pathMatch: 'full',
        component: GetallComponent
    },
    {
        path: 'list',
        component: ListComponent
    },
    {
        path: "dashboard",
        component: DashboardComponent
    }
];
