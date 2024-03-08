import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = (route, state) => {


  console.log("am inside auth guard.");
  let user = localStorage.getItem("user");
  console.log(user);
  let userObj;

  if (user != null) {
    userObj = JSON.parse(user);
    console.log(userObj);
    if (userObj.role == "user")
      return true
  }
  //needs-login
  inject(Router).navigateByUrl("needs-login");
  return false;
};
