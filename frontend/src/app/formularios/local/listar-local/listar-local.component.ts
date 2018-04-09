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

  constructor(
    private selectiveService: SelectiveService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.urlUsers = "/selective/" + this.id + "/users";
    this.urlPlaces = "/selective/" + this.id + "/places";
    this.getSelective(this.id);
  }

  getSelective(idSelective: number){
    this.selectiveService.getSelectivePlaces(idSelective).subscribe(res =>{
      this.selective = res['selective'];
      this.places = res['places'];
    });
  }

}
