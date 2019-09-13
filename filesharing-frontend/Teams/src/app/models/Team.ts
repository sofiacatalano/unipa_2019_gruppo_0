import {Bucket} from "./Bucket";

export interface Team {
  name: string;
  buckets?:Bucket[];
  contributors?: string[];
}
