import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { loginModel } from './../login.model';
import { UsuariosService } from '../usuarios.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { UsuarioModel } from './../usuario.model';

@Component({
  selector: 'app-formlogin',
  templateUrl: './formlogin.component.html',
  styleUrls: ['./formlogin.component.css']
})
export class FormloginComponent implements OnInit {
  userLogin : loginModel = new loginModel();
  mensagem;
  constructor(private usuariosService : UsuariosService, private route: Router) { }
  ngOnInit() {
  }
  fazerLogin(){
    this.usuariosService.fazerLogin(this.userLogin).subscribe(idUser =>{
        this.route.navigate(['/dashboard', idUser]);
    }, err=>{
      this.mensagem = err.error.message;
      this.route.navigate(['/login', this.mensagem]);
      }
    );
  }
}
