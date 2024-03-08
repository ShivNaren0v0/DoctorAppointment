import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  login() {

    // subscribe login api
    // inside next call back
    let user = { name: "ford", role: "user" };
    localStorage.setItem("user", JSON.stringify(user));

  }
  adminLogin() {

    // subscribe login api
    // inside next call back
    let user = { name: "ford", role: "admin" };
    localStorage.setItem("user", JSON.stringify(user));

  }
  logout() {
    localStorage.clear();
  }
}
