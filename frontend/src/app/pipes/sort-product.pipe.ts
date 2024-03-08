import { Pipe, PipeTransform } from '@angular/core';
import { Product } from '../model/product';

@Pipe({
  name: 'sortProduct',
  standalone: true
})
export class SortProductPipe implements PipeTransform {

  // products | sortProduct :'colName'
  transform(products: Product[], sortBy: string = 'id'): Product[] {

    if (products.length < 0) return products;

    switch (sortBy) {
      case "name":

        products.sort((p1, p2) => {
          if (p1.name != undefined && p2.name 
            != undefined) {
            if (p1.name > p2.name) return 1;
            else
              if (p1.name < p2.name) return -1;
          }
          return 0; // they are euqal

        });
        break;
      case "price":
        products.sort((p1, p2) => {
          if (p1.price != undefined && p2.price != undefined) {
            return p1.price - p2.price;
          }
          return 0;
        });

        break;
      case "id":
      default:
        products.sort((p1, p2) => {
          if (p1.id != undefined && p2.id != undefined) {
            return p1.id - p2.id;
          }
          return 0;
        });
    }

    return products;
  }


}
