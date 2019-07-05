import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './user/user.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
    //home
    {
        path: '',
        component: HomeComponent
    },
    //User
    {
        path: 'user',
        component: UserComponent
    }   
];
export const RoutingModule = RouterModule.forRoot(routes);