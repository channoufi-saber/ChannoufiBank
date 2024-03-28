import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  urlParam='dadddd'
  queryurlParam=''

  constructor(
    private router:Router,
    private activatedRoute:ActivatedRoute
    ) {
    console.log(this.activatedRoute);
    this.urlParam=this.activatedRoute.snapshot.params['s']
    this.queryurlParam=this.activatedRoute.snapshot.queryParams['d']
     }

  ngOnInit(): void {
  }

  async register(){
    await this.router.navigate(['register'])
  }
}
