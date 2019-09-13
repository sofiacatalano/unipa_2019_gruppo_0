import { Component, OnInit } from '@angular/core';
import {FileModel} from "../../models/FileModel";
import {BucketService} from "../../services/bucket.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-folders',
  templateUrl: './folders.component.html',
  styleUrls: ['./folders.component.scss']
})
export class FoldersComponent implements OnInit {

  public files: FileModel[];
  public team: string;
  public bucket: string;

  constructor(private bucketService: BucketService,
              private router: ActivatedRoute) { }

  ngOnInit() {
    this.router.paramMap.subscribe(params=>{
      this.team = params.get('team');
      this.bucket = params.get('bucket');
      console.log(params)
    });
  }

  private loadBucket(){
  }

  deleteAttachment(index) {
    this.files.splice(index, 1)
  }

}
