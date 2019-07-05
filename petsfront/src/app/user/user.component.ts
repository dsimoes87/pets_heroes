import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import { UserModel } from './user.model';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user : UserModel = new UserModel();
  users: Array<any> = new Array();
  constructor( private userService : UserService) { }

  ngOnInit() {
    this.listUsers();
  }
  cadastrar(){
    console.log(this.user);
    this.userService.setUser(this.user).subscribe(user => {
    }, err =>{
      console.log(err)
    });
  }
  listUsers(){
    this.userService.listUsers().subscribe(users => {
      this.users = users;
    }, err =>{
      console.log(err)
    });
  }

}
