import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {Bucket} from "../../models/Bucket";
import {Team} from "../../models/Team";
import {BucketDTO, TeamDTO, UserRoleDTO} from "../../models/models";

@Component({
  selector: 'app-bucket-dialog',
  templateUrl: './team-dialog.component.html',
  styleUrls: ['./team-dialog.component.scss']
})
export class TeamDialogComponent implements OnInit {

  public team: TeamDTO = new class implements TeamDTO {
    buckets: BucketDTO[];
    description: string;
    members: UserRoleDTO[];
    name: string;
    uuid: string;
  };

  constructor( public dialogRef: MatDialogRef<TeamDialogComponent>,
               @Inject(MAT_DIALOG_DATA) public data: any) {
    this.team.members = [];
  }

  ngOnInit() {
  }

  deleteContributor(index){
    this.team.members.splice(index,1);
  }

  addContributor(){
    this.team.members.push({email:'', admin: true, longName:'', active: false});
  }

  createBucket(){
    console.log(this.team);
    this.dialogRef.close(this.team);
  }

}
