import { Component, OnInit, Input } from '@angular/core';
import { Selective } from '../../model/Selective';

@Component({
  selector: 'selective',
  templateUrl: './selective.component.html',
  styleUrls: ['./selective.component.css']
})
export class SelectiveComponent implements OnInit {

  @Input('selective') selective: Selective = new Selective();

  constructor() { }

  ngOnInit() {
  }

}
