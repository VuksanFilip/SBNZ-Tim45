import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Artist } from 'src/app/models/Artist';
import { Genre } from 'src/app/models/Genre';
import { User } from 'src/app/models/User';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  constructor(private http: HttpClient) { }

  getArtist(id: string, token: string): Observable<User> {
    return this.http.get<any>(environment.apiHost + "artists/" + id, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    });
  }

  getArtistGenre(id: string, token: string): Observable<Genre> {
    return this.http.get<any>(environment.apiHost + "artists/" + id + "/genre", {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    });
  }

  getAllArtists(token: string): Observable<Artist[]> {
    return this.http.get<any>(environment.apiHost + "artists", {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    });
  }

}
