import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthenticationRequest } from 'src/app/services/models';
import { AuthenticationService } from 'src/app/services/services';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  authRequest:AuthenticationRequest={};
  errorMessages:Array<string>=[];

  constructor(
    private router:Router,
    private authService:AuthenticationService
    ) {
  
     }

  ngOnInit(): void {
  }

  login(){
    this.errorMessages=[];
    this.authService.authenticate({
      body:this.authRequest

    }).subscribe({
      next:(data)=>{
        console.log(data);
        localStorage.setItem('token',data.token as string);
        const helper = new JwtHelperService();
        const decodedToken = helper.decodeToken(data.token!);        
        console.log(decodedToken)
      },
      error:(err)=>{
        console.log(err)
        this.errorMessages.push(err.error.errorMessage)
      }
    })
  }

  async register(){
    await this.router.navigate(['register'])
  }
}
