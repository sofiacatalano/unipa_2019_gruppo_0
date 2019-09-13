import { Pipe, PipeTransform } from '@angular/core';
import {strictEqual} from "assert";

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(array: any, item: any, like: boolean = true): any[] {
    if (!array || !item) {
      return array;
    }


    return array.filter(x => this.compare(item, x, like));
  }

  private compare(a,b, like): boolean {

    for (let key in a) {
      console.log(like && typeof a[key] == "string" && typeof b[key] == "string" && (b[key] as string).toUpperCase().indexOf((a[key] as string).toUpperCase()) < 0 )
      if(!b[key]){
        return false
      }else if(like && typeof a[key] == "string" && typeof b[key] == "string" && (b[key] as string).toUpperCase().indexOf((a[key] as string).toUpperCase()) < 0 ){
        console.log("string", a,b)
        return false;
      }else if(!like && a[key] != b[key]){
        return false;
      }
    }
    return true;
  }

}
