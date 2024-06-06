import { Routes } from '@angular/router';
import { NotfoundComponent } from './core/components/404/notfound.component';
import { GetallComponent } from './core/components/properties/getall/getall.component';
import { LoginComponent } from './core/components/login/login.component';

export const routes: Routes = [
    {
        path: '',
        component: GetallComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: '**',
        component: NotfoundComponent
    }
];
