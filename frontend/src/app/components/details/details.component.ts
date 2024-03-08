import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-details',
  standalone: true,
  imports: [],
  templateUrl: './details.component.html',
  styleUrl: './details.component.css'
})
export class DetailsComponent {
id?:any;
  constructor(private activeRoute:ActivatedRoute){
    
    this.id = this.activeRoute.snapshot.paramMap.get('id');
  console.log("display details of product id :"+this.id);    
  }
}
