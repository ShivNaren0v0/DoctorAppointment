import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DemoService {

  data: string = "";

  constructor() { }
  getData(): string {
    return this.data;
  }
  setData(data: string): void {
    this.data = data;
  }
}
