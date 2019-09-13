import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {UserService} from "../../services/user.service";
import {RestApiService} from "../../services/rest-api.service";
import {UserDTO} from "../../models/UserDTO";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

  public name: string = 'Nome';
  public color: string = "";

  public users: UserDTO[];

  constructor(private router: ActivatedRoute,
              private userService: UserService,
              private apiService: RestApiService) { }

  ngOnInit() {
    let hello: string = this.userService.get();


    this.router.paramMap.subscribe((params: ParamMap)=>{
      if(params.get('nome')){
      this.name = params.get('nome');
    }
    });
  }

  getAllUsers(){
    this.apiService.getAllUsers().subscribe(
      (users: UserDTO[])=>{
        this.users = users;
      },
      (error)=>{
        console.log(error);
      });
  }

}
