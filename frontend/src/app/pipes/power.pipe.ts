import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'power',
  standalone: true
})
export class PowerPipe implements PipeTransform {

  transform(base: number, power: number)
    : number {
    return Math.pow(base, power);
  }

}
