import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {BucketDTO, MembershipDTO} from "../models/models";

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  private baseUrl: string = environment.apiBaseUrl+"/member";

  constructor(private httpClient: HttpClient ) { }


  public invite(uuid: string, email: string, admin: boolean){
    return this.httpClient.get(this.baseUrl+'/invite/'+uuid+'/'+email+'/'+admin);
  }

  public accept(uuid: string){
    return this.httpClient.get(this.baseUrl+'/accept/'+uuid);
  }

  public reject(uuid: string){
    return this.httpClient.get(this.baseUrl+'/reject/'+uuid);
  }

  public remove(uuid: string, email: string){
    return this.httpClient.delete(this.baseUrl+'/'+uuid+'/'+email);
  }

  public add(uuid: string, bucket: string, member: MembershipDTO){
    return this.httpClient.post(this.baseUrl+'/membership/'+uuid+'/'+bucket, member);
  }

}
