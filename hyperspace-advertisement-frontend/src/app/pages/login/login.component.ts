import { User } from './../../@business/model/user';
import { AuthenticationService } from './../../auth/authentication.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private auth: AuthenticationService) { }

  ngOnInit(): void {
  }

  testing() {
    const user = new User();
    user.userName = "sasa";
    user.password = 1234; 
    this.auth.login(user).subscribe(res=>{console.log(res)},error=>{console.log(error)});
  }
}
