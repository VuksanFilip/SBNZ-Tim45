import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rating } from 'src/app/models/Rating';
import { Recommendation } from 'src/app/models/Recommendation';
import { Song } from 'src/app/models/Song';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SongService {

  constructor(private http: HttpClient) { }

  getAllSongs(token: string): Observable<Song[]> {
    return this.http.get<any>(environment.apiHost + "songs", {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    });
  }

  listenToSong(userId: string, songId: string, token: string): Observable<Recommendation[]> {
    return this.http.get<any>(environment.apiHost + "songs/" + userId + "/listen/" + songId, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    });
  }

  findNewMusic(userId: string, token: string): Observable<Recommendation[]> {
    return this.http.get<any>(environment.apiHost + "songs/" + userId + "/new-music", {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    });
  }

  rateSong(rating: Rating, token: string): Observable<Recommendation[]> {
    return this.http.post<any>(environment.apiHost + "songs/rating", rating, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    });
  }

  getUsersFavoriteSongs(userId: string, token: string): Observable<Song[]> {
    return this.http.get<any>(environment.apiHost + "songs/" + userId + "/favorite-songs", {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    });
  }

}
