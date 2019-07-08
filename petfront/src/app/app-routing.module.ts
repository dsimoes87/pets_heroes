import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FormcadastroComponent } from './usuarios/formcadastro/formcadastro.component';
import { FormloginComponent } from './usuarios/formlogin/formlogin.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'cadastro',
    component: FormcadastroComponent
  },
  {
    path: 'login',
    component: FormloginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
})
export class AppRoutingModule { }
