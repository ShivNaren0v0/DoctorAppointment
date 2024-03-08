import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DemoService } from '../../services/demo.service';

@Component({
  selector: 'app-c1',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './c1.component.html',
  styleUrl: './c1.component.css'
})
export class C1Component {

  data:string="";
  constructor(private demoService:DemoService){
    
  }
  setData(){
    this.demoService.setData(this.data);
  }

}
