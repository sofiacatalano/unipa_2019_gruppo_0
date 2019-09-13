import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserDTO} from "../models/UserDTO";

@Injectable({
  providedIn: 'root'
})
export class RestApiService {

  private baseUrl: string = "/api";

  constructor(private httpClient:HttpClient) { }

  public saveUser(user: UserDTO){
    return this.httpClient.put<UserDTO>(this.baseUrl, user);
  }

  public getAllUsers(){
    return this.httpClient.get<UserDTO[]>(this.baseUrl);
  }

}
