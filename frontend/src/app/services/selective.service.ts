import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs/Observable";
import 'rxjs/Rx';
import { Selective } from "../model/Selective";
import { Usuario } from "../model/Usuario";
import { Local } from "../model/Local";

@Injectable()
export class SelectiveService{
    private url = 'http://localhost:8080/selective';

    constructor(
        private http: HttpClient
    ){}

    getSeletive(id:Number){
        let completeUrl = this.url + "/" + id;
        return this.http.get(completeUrl).map(res => {
            return res;
        }).catch(err => {
            return Observable.throw(new Error(err.status));
        });
    }

    getSelectiveUsers(id: number){
        let completeUrl = this.url + "/" + id + "/users";
        return this.http.get(completeUrl).map(res => {
            return res;
        }).catch(err => {
            return Observable.throw(new Error(err.status));
        });
    }

    getSelectivePlaces(id: number){
        let completeUrl = this.url + "/" + id + "/places";
        return this.http.get(completeUrl).map(res => {
            return res;
        }).catch(err => {
            return Observable.throw(new Error(err.status));
        });
    }

    postSelectiveUser(id: number, usuario: Usuario){
        let completeUrl = this.url + "/" + id + "/user";
        return this.http.post(completeUrl,usuario).map(res => {
            return res;
        }).catch(err => {
            return Observable.throw(new Error(err.status));
        });
    }

    postSelectivePlace(id: number, local: Local){
        let completeUrl = this.url + "/" + id + "/place";
        return this.http.post(completeUrl,local).map(res => {
            return res;
        }).catch(err => {
            return Observable.throw(new Error(err.status));
        });
    }
}