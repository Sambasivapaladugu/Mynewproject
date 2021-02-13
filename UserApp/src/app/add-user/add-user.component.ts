import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { User } from '../User';
import { UserServiceService } from '../user-service.service';


@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})


export class AddUserComponent implements OnInit {
  opt=false;
  constructor(public dialogRef: MatDialogRef<AddUserComponent>, private userService :UserServiceService,
    @Inject(MAT_DIALOG_DATA) public data: User) { }

    private user :any ={};
    onNoClick(): void {
      this.dialogRef.close();
    }

  ngOnInit() {
   
  }

  
  saveUser(user:any,userForm:any){
    
    user.id=Math.random();
    console.log(user);
    this.userService.saveUser(user).subscribe((response)=>{
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
