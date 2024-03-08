import { Component } from '@angular/core';
import { DemoService } from '../../services/demo.service';

@Component({
  selector: 'app-c2',
  standalone: true,
  imports: [],
  templateUrl: './c2.component.html',
  styleUrl: './c2.component.css'
})
export class C2Component {

  constructor(private demoService: DemoService) {
    console.log(this.demoService.getData());
  }
}
