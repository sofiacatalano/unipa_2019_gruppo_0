import {Component, Inject, OnInit} from '@angular/core';
import {Bucket} from "../../models/Bucket";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {BucketDTO} from "../../models/models";

@Component({
  selector: 'app-bucket-dialog',
  templateUrl: './bucket-dialog.component.html',
  styleUrls: ['./bucket-dialog.component.scss']
})
export class BucketDialogComponent implements OnInit {

  public bucket: BucketDTO = new class implements BucketDTO {
    bucketType: string;
    description: string;
    name: string;
  };

  constructor(public dialogRef: MatDialogRef<BucketDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }

  addBucket(){
    this.dialogRef.close(this.bucket);
  }

}
