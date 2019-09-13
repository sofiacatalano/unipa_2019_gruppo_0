import {FileModel} from "./FileModel";

export interface Bucket {
  name: string;
  files?:FileModel[];
}
