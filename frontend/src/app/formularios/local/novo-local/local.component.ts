import { Component, OnInit } from '@angular/core';
import { SelectiveService } from '../../../services/selective.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Selective } from '../../../model/Selective';
import { Local } from '../../../model/Local';

@Component({
  selector: 'app-local',
  templateUrl: './local.component.html',
  styleUrls: ['./local.component.css']
})
export class LocalComponent implements OnInit {

  id: number;
  selective: Selective;

  local: Local = new Local();

  editar: boolean = false;

  urlUsers: string;
  urlPlaces: string;

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

    if(localStorage.getItem("local") != null){
      this.local = JSON.parse(localStorage.getItem("local"));
      this.editar = true;
      localStorage.clear();
    }
  }

  getSelective(idSelective){
    this.selectiveService.getSeletive(idSelective).subscribe(res =>{
      this.selective = res;
    });
  }

  gravarLocal(){
    if(this.editar){
      console.log("EDITAR");
      this.selectiveService.updateSelectivePlace(this.id,this.local).subscribe(res =>{
        this.router.navigate(['/selective/' + this.id + '/places'])
      });
    }
    else{
      this.selectiveService.postSelectivePlace(this.id,this.local).subscribe(res =>{
        this.router.navigate(['/selective/' + this.id + '/places'])
      });
    }
  }
}
