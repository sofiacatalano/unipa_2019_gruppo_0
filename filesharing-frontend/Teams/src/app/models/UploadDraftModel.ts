import {UploadModel} from "./UplaodModel";
import {EventEmitter} from "@angular/core";
import {UploadProgressModel} from "./UploadProgressModel";

export class UploadDraftModel{
  public idOfferta: number;
  public field;
  public bollo:string[] = [];
  public tipoBollo: string;
  public file: File;
  public type: string;
  public filename: string;
  public partecipanteId: string;
  public fileUploadEvent: EventEmitter<UploadProgressModel>;
  get bolli(): string{
    return this.bollo.join(";");
  }

  toUploadModel(){
    let tmp = new UploadModel();
    tmp.filename=this.file.name;
    tmp.type=this.type;
    tmp.bollo=this.bollo.join(";");
    tmp.size=this.file.size;
    tmp.hash=null;
    tmp.bolli = this.bolli;
    tmp.partecipanteId = this.partecipanteId;
    tmp.tipoBollo = this.tipoBollo;
    return tmp;
  }
}
