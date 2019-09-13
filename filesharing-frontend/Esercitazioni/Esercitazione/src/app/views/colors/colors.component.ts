import { Component, OnInit } from '@angular/core';
import {Color} from "../../model/Color";
import {ColorService} from "../../services/color.service";

@Component({
  selector: 'app-colors',
  templateUrl: './colors.component.html',
  styleUrls: ['./colors.component.scss']
})
export class ColorsComponent implements OnInit {

  coloreDaCercare: string;

  colors: Color[];

  constructor(private colorService: ColorService) {
  }

  ngOnInit() {
    this.colors = this.colorService.getColors();
  }

  cercaColore(colore){
    if(colore && colore.length > 1){
      this.coloreDaCercare = colore;
    }else{
      this.coloreDaCercare = null
    }
  }



}
