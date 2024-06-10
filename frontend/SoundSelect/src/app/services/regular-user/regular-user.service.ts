import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/User';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegularUserService {

  constructor(private http: HttpClient) { }

  getRegularUser(id: string, token: string): Observable<User> {
    return this.http.get<any>(environment.apiHost + "regular-users/" + id, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    });
  }
  
}
