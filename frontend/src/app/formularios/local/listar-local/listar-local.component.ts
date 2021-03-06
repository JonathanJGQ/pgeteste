import { Component, OnInit } from '@angular/core';
import { Selective } from '../../../model/Selective';
import { Local } from '../../../model/Local';
import { SelectiveService } from '../../../services/selective.service';
import { Router, ActivatedRoute, Params, RoutesRecognized } from '@angular/router';

@Component({
  selector: 'app-listar-local',
  templateUrl: './listar-local.component.html',
  styleUrls: ['./listar-local.component.css']
})
export class ListarLocalComponent implements OnInit {

  id: number;
  selective: Selective;
  places: Local[];

  urlUsers: string;
  urlPlaces: string;
  urlNovo: string;

  constructor(
    private selectiveService: SelectiveService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.urlUsers = "/selective/" + this.id + "/users";
    this.urlPlaces = "/selective/" + this.id + "/places";
    this.urlNovo = "/selective/" + this.id + "/places/new";
    this.getSelective(this.id);
  }

  getSelective(idSelective: number){
    this.selectiveService.getSelectivePlaces(idSelective).subscribe(res =>{
      this.selective = res['selective'];
      this.places = res['places'];
    });
  }

  deletaLocal(codigo: number){
    for(let local of this.places){
      if(local.localCodigo == codigo){
        this.places.splice(this.places.indexOf(local),1);
      }
    }
  }

  editarLocal(local: Local){
    localStorage.setItem("local", JSON.stringify(local));
  }

}
