import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PetsService } from './../pets.service';
import { petModel } from '../pet.model';

@Component({
  selector: 'app-cadastro-pet',
  templateUrl: './cadastro-pet.component.html',
  styleUrls: ['./cadastro-pet.component.css']
})
export class CadastroPetComponent implements OnInit {
  pet : petModel = new petModel;
  erro;
  private idUser;
  constructor(private router: Router, 
              private route: ActivatedRoute,
              private petsService: PetsService) { }

  ngOnInit() {
    this.idUser = +this.route.snapshot.paramMap.get('idUser');
  }
  cadastrarPet(){
    this.petsService.cadastrarpet(this.idUser,this.pet).subscribe(pet =>{
      this.pet = new petModel();
      console.log("cadastrado com sucesso!");
      this.router.navigate(['/dashboard', this.idUser]);
    }, err =>{
      this.erro = err.error.message;
      console.log(this.erro);
      this.router.navigate(['/dashboard'+ this.idUser, this.erro]);
    }
    )}

}
