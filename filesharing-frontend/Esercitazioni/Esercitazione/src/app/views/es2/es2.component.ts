import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Color} from "../../model/Color";
import {ColorService} from "../../services/color.service";

@Component({
  selector: 'app-es2',
  templateUrl: './es2.component.html',
  styleUrls: ['./es2.component.scss']
})
export class Es2Component implements OnInit {

  public colors: Color[];;

  public selectedColor: string = "";

  public newColor: Color = new Color("", "");

  constructor(private colorService: ColorService) { }

  ngOnInit() {
    this.colors = this.colorService.getColors();
  }

  createColor(){
    this.colorService.addColor(this.newColor);
    this.colors = this.colorService.getColors();
    this.newColor = new Color("", "");
  }
}
