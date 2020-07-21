import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  username = '';
  password = '';
  invalidCredentialsMessage = 'Invalid username or password!';
  invalidAuthorization = false;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  authorize() {
    if (this.username === 'hieu' && this.password === 'hieu') {
      this.invalidAuthorization = false;
      console.log(`Username: ${this.username}`);
      console.log(`Password: ${this.password}`);
      this.router.navigate(['home', this.username]);
    } else {
      this.invalidAuthorization = true;
    }
  }

}
