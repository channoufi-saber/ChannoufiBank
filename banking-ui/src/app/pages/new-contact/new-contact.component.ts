import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HelperService } from 'src/app/services/helper/helper.service';
import { ContactDto } from 'src/app/services/models/contact-dto';
import { ContactService } from 'src/app/services/services';

@Component({
  selector: 'app-new-contact',
  templateUrl: './new-contact.component.html',
  styleUrls: ['./new-contact.component.css']
})
export class NewContactComponent implements OnInit {

  contact:ContactDto={};
  errorMessages:Array<string>=[];
  constructor(
    private contactService:ContactService,
    private helperService:HelperService,
    private router:Router
    ) { }

  ngOnInit(): void {
  }

  save(){
    this.errorMessages=[];
    this.contact.userId=this.helperService.userId;
    this.contactService.save2({
      body:this.contact
    }).subscribe({
      next:async()=>{
        await this.router.navigate(['user/my-contact-list'])
      },
      error:(err)=>{
        this.errorMessages=err.error.validationErrors;
      }
    })
  }

  async cancel(){
    await this.router.navigate(['user/my-contact-list']);
  }
}
