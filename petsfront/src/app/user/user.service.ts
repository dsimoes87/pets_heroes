import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserModel } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient) { }
  listUsers() : Observable<any>{
    return this.http.get("http://localhost:8080/api/user");
  }
  setUser(user : UserModel) : Observable<any>{
    return this.http.post("http://localhost:8080/api/user", user);
  }
}
