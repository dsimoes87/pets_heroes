import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { petModel } from './pet.model';

@Injectable({
  providedIn: 'root'
})
export class PetsService {

  constructor(private http: HttpClient) { }
  listarPets(): Observable<any>{
    return this.http.get("http://localhost:8080/api/pets");
  }
  cadastrarpet(idUser, pet : petModel): Observable<any>{
    return this.http.post('http://localhost:8080/api/pets/'+ idUser, pet);
  }
  petsByUser(idUser): Observable<any>{
    return this.http.get('http://localhost:8080/api/pets/'+ idUser);
  }
  deletarPet(idPet) : Observable<any>{
    return this.http.delete('http://localhost:8080/api/pets/'+ idPet);
  }
}
