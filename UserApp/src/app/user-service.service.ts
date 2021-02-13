import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, BehaviorSubject } from 'rxjs';
import { User } from './User';


@Injectable()
export class UserServiceService {

  user:Array<any>=[];
  subject :BehaviorSubject<Array<User>>= new BehaviorSubject(this.user);

  constructor(private http: HttpClient) { }


  saveUser(user: User): Observable<User>{
    return this.http.post<User>(`http://localhost:8080/api/v1/saveuser`,user);
  }

  editUser(id: string){
    return this.http.get(`http://localhost:8080/api/v1/user/${id}`);

  }
  edit(user, id){
    return this.http.put(`http://localhost:8080/api/v1/edit/${id}`,user);
  }

  delete(id){
    return this.http.delete(`http://localhost:8080/api/v1/deleteuser/${id}`);
  }
}
