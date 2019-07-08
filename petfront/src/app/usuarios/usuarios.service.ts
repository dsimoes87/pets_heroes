import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioModel } from './usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(private http: HttpClient) { }

  listarUsuarios() : Observable<any>{
    return this.http.get("http://localhost:8080/api/user");
  }
  cadastrarUsuario(usuario: UsuarioModel) : Observable<any>{
    return this.http.post("http://localhost:8080/api/user", usuario);
  }
  buscarUsuario(id: number): Observable<any>{
    return this.http.get(`http://localhost:8080/api/user/${id}`);
  }
}
