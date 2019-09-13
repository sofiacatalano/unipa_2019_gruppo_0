import { Injectable } from '@angular/core';
import {TeamService} from "./team.service";
import {Bucket} from "../models/Bucket";
import {Team} from "../models/Team";
import {FileModel} from "../models/FileModel";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {BucketDTO} from "../models/models";

@Injectable({
  providedIn: 'root'
})
export class BucketService {

  private baseUrl: string = environment.apiBaseUrl+"/bucket";

  constructor(private httpClient: HttpClient ) { }


  public save(uuid: string, bucket: BucketDTO){
    return this.httpClient.put(this.baseUrl+'/'+uuid, bucket);
  }

  public delete(uuid: string, bucketName: string){
    return this.httpClient.delete(this.baseUrl+'/'+uuid+'/'+bucketName);
  }

  public type(){
    return this.httpClient.get(this.baseUrl+'/type');
  }
}
