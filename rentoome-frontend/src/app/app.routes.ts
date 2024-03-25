import { Routes } from '@angular/router';
import { GetallComponent } from './core/components/propertyTypes/getall/getall.component';
import { ListComponent } from './core/components/properties/list/list.component';
import { AddComponent } from './core/components/properties/add/add.component';

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
        path: 'add',
        component: AddComponent
    }
];
