import { Pipe, PipeTransform } from '@angular/core';
import {TeamDTO, UserRoleDTO} from "../models/models";
import {KeycloakService} from "keycloak-angular";

@Pipe({
  name: 'isCurrentMemberActive'
})
export class MemberPipe implements PipeTransform {

  constructor(private keycloakService: KeycloakService){}

  transform(value: UserRoleDTO[]): boolean {
    let result: UserRoleDTO[] = [];
    let username: string = this.keycloakService.getUsername();
    if(value){
      for(let u of value){
        if(u.email == username){
          return u.active;
        }
      }
    }
    return false;
  }

}
