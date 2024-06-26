import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDto } from 'src/app/services/models/user-dto';
import { AuthenticationService } from 'src/app/services/services';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userDto:UserDto={
      email: '',
      firstname: '',
      lastname: '',
      password: ''
  }
  errorMessages:Array<string>=[];
  constructor(
    private router:Router,
    private authService:AuthenticationService
    ) { }

  ngOnInit(): void {
  }

  async login(){
    await this.router.navigate(['login'])
  }

  register(){
    this.errorMessages=[];
    this.authService.register({
      body:this.userDto
    }).subscribe({
      next:async(data)=>{
        console.log(data)
        await this.router.navigate(['confirm-register'])
      },
      error:(err)=>{
        this.errorMessages=err.error.validationErrors;
      }
    })
  }

}
