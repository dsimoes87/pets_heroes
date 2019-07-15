import { Component, OnInit } from '@angular/core';
import { UsuarioModel } from '../usuario.model';
import { UsuariosService } from '../usuarios.service';
import { Router } from '@angular/router';

@Component({
  selector: 'user-formcadastro',
  templateUrl: './formcadastro.component.html',
  styleUrls: ['./formcadastro.component.css']
})
export class FormcadastroComponent implements OnInit {

  constructor(private usuariosService : UsuariosService, private route: Router ) { }
  usuario: UsuarioModel = new UsuarioModel();
  erro;
  ngOnInit() {
  }
  cadastrarUsuario(){
    this.usuariosService.cadastrarUsuario(this.usuario).subscribe(usuario =>{
      this.route.navigate(['/login']);
    }, err =>{
      this.erro = err.error.message;
      console.log(this.erro);
      this.route.navigate(['/cadastro', this.erro]);
    });
    
  }
}
