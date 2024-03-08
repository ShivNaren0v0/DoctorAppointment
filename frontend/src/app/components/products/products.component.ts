import { Component } from '@angular/core';
import { Product } from '../../model/product';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {
  newProduct:Product=new Product();
  products:Product[]=[];
  constructor(private router:Router){
    this.products.push(new Product(1,"Dell Laptop",23000.0));
    this.products.push(new Product(2,"Dell monitor",10000.0));
    
  }
  showDetails(id?:number){
    this.router.navigateByUrl('details/'+id);
  }

}
