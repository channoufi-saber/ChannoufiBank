import { Component, OnInit } from '@angular/core';
import { HelperService } from 'src/app/services/helper/helper.service';
import { ContactDto } from 'src/app/services/models/contact-dto';
import { ContactService } from 'src/app/services/services/contact.service';

@Component({
  selector: 'app-my-contact-list',
  templateUrl: './my-contact-list.component.html',
  styleUrls: ['./my-contact-list.component.css']
})
export class MyContactListComponent implements OnInit {

  contacts:Array<ContactDto>=[];
  constructor(
    private contactService:ContactService,
    private helperService:HelperService
    ) { }

  ngOnInit(): void {
    this.findAllContactByUser();
  }

  private findAllContactByUser(){
    this.contactService.findAllByUserId1({
      'user-id':this.helperService.userId
    }).subscribe({
      next:(data)=>{
        this.contacts=data;
      }
    })
  }


}
