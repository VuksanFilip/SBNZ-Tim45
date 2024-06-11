import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FactsService {

  constructor(private http: HttpClient) { }

  getFactsAboutSong(songId: string, token: string): Observable<string[]> {
    return this.http.get<any>(environment.apiHost + "facts/" + songId + "/song-facts", {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    });
  }

  getFactsAboutAlbum(albumId: string, token: string): Observable<string[]> {
    return this.http.get<any>(environment.apiHost + "facts/" + albumId + "/album-facts", {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    });
  }

  getFactsAboutArtist(artistId: string, token: string): Observable<string[]> {
    return this.http.get<any>(environment.apiHost + "facts/" + artistId + "/artist-facts", {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    });
  }

}
