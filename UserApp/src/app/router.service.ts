import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable()
export class RouterService {

  constructor(private router:Router) { }

  toUsers()
  {
    this.router.navigate(["/users"]);
  }

  toDashboard()
  {
    this.router.navigate(["/dashboard"]);
  }

}
