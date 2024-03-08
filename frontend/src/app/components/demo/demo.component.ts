import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Product } from '../../model/product';
import { SquarePipe } from '../../pipes/square.pipe';
import { PowerPipe } from '../../pipes/power.pipe';
import { ConcatPipe } from '../../pipes/concat.pipe';
import { SortProductPipe } from '../../pipes/sort-product.pipe';
import { SearchProductPipe } from '../../pipes/search-product.pipe';
@Component({
  selector: 'app-demo',
  standalone: true,
  imports: [FormsModule, CommonModule,SquarePipe,
    PowerPipe,ConcatPipe,SortProductPipe,SearchProductPipe ],
  templateUrl: './demo.component.html',
  styleUrl: './demo.component.css'
})
export class DemoComponent {


  query : string="";
  a: number = 0.259;
  b: number = 1.3495;
  c: number = 123.4567; // 2.2-4


  todayDate: Date = new Date();
  title = 'my-app';
  fruits: string[] = ["apple", "mango", "grapes"];
  product = { id: 1, name: "Dell", price: 100 };
  imageUrl: string = "./assets/disny.jpg"
  isDisabled: boolean = true;
  userName: string = "";
  newProduct: Product = new Product();
  choice: number = 4;
  products: Product[] = [];

  isAddEnabled: boolean = false;
  enableAddProduct() {
    this.isAddEnabled = true;
  }
  constructor() {
    this.products.push(new Product(5, "Mouse", 450.0));
    this.products.push(new Product(2, "Monitor", 7500.0));
    this.products.push(new Product(1, "KeyBoard", 1000.0));
    this.products.push(new Product(3, "Cable", 800.0));
  }
  addProduct() {
    console.log(this.newProduct);
    this.products.push(this.newProduct);
    this.newProduct = new Product();
    this.isAddEnabled = false;
  }
  clearName() {
    this.userName = "";
  }
  addName() {
    console.log(this.userName);
  }
  public clickHandler() {
    console.log(this.fruits);
  }
  toggleButton() {
    this.isDisabled = !this.isDisabled;
  }

}
