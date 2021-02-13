import { Component, OnInit } from '@angular/core';
import { RouterService } from '../router.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private routerService : RouterService) { }

  ngOnInit() {
  }

  getUsers()
  {
    console.log("clicked");
  this.routerService.toUsers();
  }

}
