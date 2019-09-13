import { Injectable } from '@angular/core';
import {Color} from "../model/Color";

@Injectable({
  providedIn: 'root'
})
export class ColorService {

  private colors: Color[] = [];

  constructor() {
    this.colors.push(new Color("Notte", "#252832"));
    this.colors.push(new Color("Blu chiaro", "#0000FF"));
    this.colors.push(new Color("Blu scuro", "#0000A0"));
    this.colors.push(new Color("Giallo", "#FFFF00"));
    this.colors.push(new Color("Verde", "#00FF00"));
    this.colors.push(new Color("Cherry", "#7E0B27"));
    this.colors.push(new Color("Rosa", "#FF00FF"));
    this.colors.push(new Color("Ocean", "#13EEE4"));
    this.colors.push(new Color("Eclipse", "#F7941E"));
    this.colors.push(new Color("Iris", "#6B2CDF"));
  }

  addColor(color: Color){
    this.colors.push(color);
  }

  getColors(): Color[]{
    return this.colors;
  }

}
