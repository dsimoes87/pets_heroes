import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './user.component';
import { RoutingModule } from '../app.router';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    UserComponent
  ],
  imports: [
  
  CommonModule,
    RoutingModule,
    FormsModule
  ],
  exports:[
    UserComponent
  ]
})
export class UserModule { }
