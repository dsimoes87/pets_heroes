import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PetsComponent } from './pets.component';
import { PetsService } from './pets.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from '../app-routing.module';
import { CadastroPetComponent } from './cadastro-pet/cadastro-pet.component';
import { UsuariosModule } from '../usuarios/usuarios.module';

@NgModule({
  declarations: [PetsComponent, CadastroPetComponent],
  imports: [
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    UsuariosModule
  ],
  providers: [
    PetsService
  ],
  exports:[
    PetsComponent
  ]
})
export class PetsModule { }
