import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FileModel} from "../../models/FileModel";
import {UploadService} from "../../models/UploadService";

@Component({
  selector: 'app-upload-file',
  templateUrl: './upload-file.component.html',
  styleUrls: ['./upload-file.component.scss']
})
export class UploadFileComponent implements OnInit {

  @Input() files: FileModel[] = [];
  @Output() onUpload: EventEmitter<File> = new EventEmitter<File>();

  constructor() { }

  ngOnInit() {
  }


  uploadFile(event) {
    for (let index = 0; index < event.length; index++) {
      const element = event[index];
      this.onUpload.emit(element);
    }
  }


}
