import { Component, OnInit } from '@angular/core';
import { Stack } from '../stack';

@Component({
  selector: 'app-current-tech-stack',
  templateUrl: './current-tech-stack.component.html',
  styleUrls: ['./current-tech-stack.component.css']
})
export class CurrentTechStackComponent implements OnInit {

  stacks: Array<Stack>;

  constructor() { }

  ngOnInit() {


  }

}
