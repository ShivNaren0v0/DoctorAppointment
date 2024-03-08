import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'concat',
  standalone: true
})
export class ConcatPipe implements PipeTransform {

  //{{'*' | concat :'2s':'3s':'4s'}}
  transform(symbol: string, ...strArray: string[]): string {
    let resultStr: string = "";
    for (let str of strArray) {
      resultStr = resultStr.concat(str);
      resultStr = resultStr.concat(symbol);
    }
    return resultStr;
  }

}
