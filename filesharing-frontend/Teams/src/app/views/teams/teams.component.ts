import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {TeamService} from "../../services/team.service";
import {TeamDTO} from "../../models/models";
import {SYNC_TYPE, SyncService} from "../../services/sync.service";
import {MemberService} from "../../services/member.service";

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.scss']
})
export class TeamsComponent implements OnInit {

  public team:string;

  @Input() teams: TeamDTO[];

  constructor(private router: ActivatedRoute,
              private teamService: TeamService,
              private memberService: MemberService,
              private syncService:SyncService) { }

  ngOnInit() {
      this.loadTeam();
      this.syncService.register().subscribe((type: SYNC_TYPE) => {
        if(type == SYNC_TYPE.Team) {
          this.loadTeam();
        }
    });

  }

  private loadTeam(){
    this.teamService.myTeams().subscribe(data => {
      this.teams = data;
      this.teamService.setCache(data);
    });
  }

  public accept(team: string){
    this.memberService.accept(team).subscribe(data=>{
      this.syncService.sendEvent(SYNC_TYPE.Team);
    })
  }

  public reject(team: string){
    this.memberService.reject(team).subscribe(data=>{
      this.syncService.sendEvent(SYNC_TYPE.Team);
    })
  }

}
