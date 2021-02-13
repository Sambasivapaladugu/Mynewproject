import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';
import {User} from '../User';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { AddUserComponent } from '../add-user/add-user.component';
import { EditUserComponent } from '../edit-user/edit-user.component';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { RouterService } from '../router.service';


@Component({
  selector: 'app-users-info',
  templateUrl: './users-info.component.html',
  styleUrls: ['./users-info.component.css']
})


export class UsersInfoComponent implements OnInit {
  dataSource:any[];
  userInfo:any;
  user:Array<User>=[];
 // user:Array<any>=[];
  subject :BehaviorSubject<Array<User>>= new BehaviorSubject(this.user);

  constructor(private userService : UserServiceService, private dialog : MatDialog, 
    private http: HttpClient, private routerService :RouterService) { }
  displayedColumns: string[] = ['name', 'email', 'role','status','action1','action2'];
  ngOnInit() {
    return this.http.get<Array<User>>(`http://localhost:8080/api/v1/users`).subscribe(
      (data)=>{
        this.user=data;
        this.subject.next(this.user);
        console.log(this.subject);
      }
    )
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AddUserComponent, {
      width: '350px',
     
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  editUser(id)
  {
    console.log(id);
    this.userService.editUser(id).subscribe(
      data=>{
        console.log(data);
        this.userInfo=data;
      },
      error=>{
        console.log(error);
      }
    )
    const dialogRef = this.dialog.open(EditUserComponent, {
      width: '350px',
      data:{
        userId:id
      }

    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('Edit dialog was closed');
    });

  }
deletemsg=false;
  delete(id){
    this.userService.delete(id).subscribe(
    data=>{"user has been deleted";
    this.deletemsg=true;
    location.reload
    this.routerService.toUsers();
    })
    location.reload();
  }
}
