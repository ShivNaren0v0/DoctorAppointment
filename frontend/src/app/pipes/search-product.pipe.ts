import { Pipe, PipeTransform } from '@angular/core';
import { Product } from '../model/product';

@Pipe({
  name: 'searchProduct',
  standalone: true
})
export class SearchProductPipe implements PipeTransform {

  transform(products: Product[], query: string): Product[] {

    if (products.length < 1 || query == "" || query == undefined) return products;
    return products.filter((p) => {
      return p.name!.toLowerCase().includes(query.toLowerCase());
      //return JSON.stringify(p).toLowerCase().includes(query.toLowerCase());
    });
  }

}
