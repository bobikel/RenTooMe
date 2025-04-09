import { Routes } from '@angular/router';
import { HomeComponent } from './pages/admin/home/home.component';

export const routes: Routes = [
    {
        path: "",
        loadChildren: () => import('./core/session.module').then(m => m.SessionModule)
    },
    {
        path: "home",
        component: HomeComponent
    }
];
