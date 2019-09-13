import {Component, OnInit} from '@angular/core';
import {TeamService} from "../../services/team.service";
import {ActivatedRoute} from "@angular/router";
import {BucketDTO, TeamDTO} from "../../models/models";
import {SYNC_TYPE, SyncService} from "../../services/sync.service";

@Component({
  selector: 'app-bucket',
  templateUrl: './buckets.component.html',
  styleUrls: ['./buckets.component.scss']
})
export class BucketsComponent implements OnInit {

  public buckets: BucketDTO[];
  public team: string;
  public teamDetail: TeamDTO;
  public teamDTO: TeamDTO;

  constructor(private teamService: TeamService,
              private syncService: SyncService,
              private router: ActivatedRoute) { }

  ngOnInit() {
    this.router.paramMap.subscribe(params=>{
      this.team = params.get('team');
      console.log(params)
      this.loadBuckets();
    });
    this.syncService.register().subscribe((type: SYNC_TYPE)=>{
      if(type == SYNC_TYPE.Bucket){
        this.loadBuckets();
      }
    });

  }

  private loadBuckets(){
    this.teamDTO = this.teamService.getTeamByUUID(this.team);
    this.teamService.getTeam(this.team).subscribe((data : TeamDTO)=>{
      this.teamDetail = data;
      this.buckets = data.buckets;
    })
    // this.buckets = this.bucketService.getTeamBuckets(this.team)
  }

}
