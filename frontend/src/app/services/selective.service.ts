import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs/Observable";
import 'rxjs/Rx';
import { Selective } from "../model/Selective";

@Injectable()
export class SelectiveService{
    private url = 'http://localhost:8080/selective';

    constructor(
        private http: HttpClient
    ){}

    getSelectiveUsers(id: number){
        let completeUrl = this.url + "/" + id + "/users"
        return this.http.get(completeUrl).map(res => {
            return res;
        }).catch(err => {
            return Observable.throw(new Error(err.status));
        });
    }

    getSelectivePlaces(id: number){
        let completeUrl = this.url + "/" + id + "/places"
        return this.http.get(completeUrl).map(res => {
            return res;
        }).catch(err => {
            return Observable.throw(new Error(err.status));
        });
    }
}