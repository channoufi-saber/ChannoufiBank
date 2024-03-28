import { Component, OnInit } from '@angular/core';
import { LightInfoInput } from 'src/app/components/light-info/light-info.component';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  accountInfoList: Array<LightInfoInput> =[];

  constructor() { }

  ngOnInit(): void {
    this.initializeAccountInfo();
  }

  private initializeAccountInfo(){

    this.accountInfoList = [
      {
        title: 'Account balance',
        amount: 5555,
        infoStyle: 'bg-primary'
      },
      {
        title: 'Highest transfer',
        amount: 66666,
        infoStyle: 'bg-warning'
      },
      {
        title: 'Highest deposit',
        amount: 55522,
        infoStyle: 'bg-success'
      }
    ];
  }
}
