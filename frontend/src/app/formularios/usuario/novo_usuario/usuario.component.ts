import { Component, OnInit } from '@angular/core';
import { SelectiveService } from '../../../services/selective.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Selective } from '../../../model/Selective';
import { Usuario } from '../../../model/Usuario';

@Component({
  selector: 'novo-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  id: number;
  selective: Selective;
  
  urlUsers: string;
  urlPlaces: string;

  usuario: Usuario = new Usuario();
  
  sexoMap = new Map();

  constructor(
    private selectiveService: SelectiveService,
    private activateRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.id = +this.activateRoute.snapshot.paramMap.get('id');
    this.urlUsers = "/selective/" + this.id + "/users";
    this.urlPlaces = "/selective/" + this.id + "/places";
    this.getSelective(this.id);

    this.sexoMap.set('M', 'Masculino');
    this.sexoMap.set('F', 'Feminino');
  }
  
  getSelective(idSelective){
    this.selectiveService.getSeletive(idSelective).subscribe(res =>{
      this.selective = res;
    });
  }

  gravarUsuario(){
    this.selectiveService.postSelectiveUser(this.id,this.usuario).subscribe(res =>{
      this.router.navigate(['/selective/' + this.id + '/users'])
    });
  }

}
