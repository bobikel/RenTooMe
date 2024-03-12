import { Routes } from '@angular/router';
import { GetallComponent } from './core/components/propertyTypes/getall/getall.component';

export const routes: Routes = [
    {
        path:'',
        pathMatch:'full',
        component:GetallComponent
    }
];
