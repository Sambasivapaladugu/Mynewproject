import { Component, OnInit,Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { User } from '../User';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  opt= false;
 private user :any={};
  user1 :User;
  constructor(public dialogRef: MatDialogRef<EditUserComponent>, private userService :UserServiceService,
    @Inject(MAT_DIALOG_DATA) public data: any ) { }

  private id :string;
  ngOnInit() {
    this.userService.editUser(this.data.userId).subscribe(
      data=>{
        console.log(data);
        this.user=data;
      }
    )
  }
  
  edit(user:any,userForm:any){
    this.userService.edit(user,user.id).subscribe((response)=>{
        if(response){
          console.log(response);
          userForm.reset();
           this.opt=true; 
        }
    })
  }

  diaClose():void
  {
    this.dialogRef.close();
    location.reload();
  }

}
