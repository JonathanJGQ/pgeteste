import { Component, OnInit } from '@angular/core';
import { SelectiveService } from '../../../services/selective.service';
import { Router, ActivatedRoute, Params, RoutesRecognized } from '@angular/router';
import { HttpParams } from '@angular/common/http';
import { Selective } from '../../../model/Selective';
import { Usuario } from '../../../model/Usuario';

@Component({
  selector: 'listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.css']
})
export class ListarUsuarioComponent implements OnInit {

  id: number;
  private sub: any;
  selective: Selective;
  users: Usuario[];

  urlUsers: string;
  urlPlaces: string;
  urlNovo: string;

  constructor(
    private selectiveService: SelectiveService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.urlUsers = "/selective/" + this.id + "/users";
    this.urlPlaces = "/selective/" + this.id + "/places";
    this.urlNovo = "/selective/" + this.id + "/users/new";
    this.getSelective(this.id);
  }

  getSelective(idSelective: number){
    this.selectiveService.getSelectiveUsers(idSelective).subscribe(res =>{
      this.selective = res['selective'];
      this.users = res['users'];
    });
  }

  deletaUsuario(codigo: number){
    for(let usuario of this.users){
      if(usuario.usuarioCodigo == codigo){
        this.users.splice(this.users.indexOf(usuario),1);
      }
    }
  }

  editarUsuario(usuario: Usuario){
    localStorage.setItem("usuario", JSON.stringify(usuario));
  }
}
