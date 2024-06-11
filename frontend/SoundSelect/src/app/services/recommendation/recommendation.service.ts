import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserMood } from 'src/app/models/UserMood';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {

  constructor(private http: HttpClient) { }

  getRecommendationForMood(userId: string, userMood: UserMood, token: string): Observable<any> {
    return this.http.put<any>(environment.apiHost + "recommendations/" + userId + "/mood", userMood, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    });
  }
}
