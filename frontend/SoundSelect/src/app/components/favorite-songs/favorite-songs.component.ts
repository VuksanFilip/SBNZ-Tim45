import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatTabsModule } from '@angular/material/tabs';
import { RouterModule } from '@angular/router';
import { Song } from 'src/app/models/Song';
import { FactsService } from 'src/app/services/facts/facts.service';
import { SongService } from 'src/app/services/song/song.service';
import { FactsDialogComponent } from '../facts-dialog/facts-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { RatingDialogComponent } from '../rating-dialog/rating-dialog.component';

@Component({
  selector: 'app-favorite-songs',
  templateUrl: './favorite-songs.component.html',
  styleUrls: ['./favorite-songs.component.css'],
  standalone: true,
  imports: [RatingDialogComponent, FactsDialogComponent, MatFormFieldModule, MatInputModule, MatIconModule, MatRadioModule, MatCardModule, FormsModule, RouterModule, MatTabsModule, CommonModule]
})
export class FavoriteSongsComponent implements OnInit {

  songs: Song[] = [];

  constructor(private songService: SongService, private factsService: FactsService, public dialog: MatDialog) {}

  ngOnInit(): void {
    const token = localStorage.getItem('token');
    const userId = localStorage.getItem('id');
    this.songService.getUsersFavoriteSongs(userId!, token!).subscribe((response) => {
      this.songs = response;
      console.log(response);
    })
  }

  listen(id: string) {
    const token = localStorage.getItem('token');
    const userId = localStorage.getItem('id');
    console.log(token);
    this.songService.listenToSong(userId!, id, token!).subscribe((response) => {
      if (response.length != 0) {
        alert("You have new song recommendations! Check Recommendations tab.")
      }
    })
  }

  rate(id: string) {
    const data = {
      id: id
    };
    const dialogRef = this.dialog.open(RatingDialogComponent, {
      data: data
    });
  }
  
  openDialog(songId: string) {
    const token = localStorage.getItem('token');
    this.factsService.getFactsAboutSong(songId, token!).subscribe((response) => {
      const data = {
        title: "a Song",
        content: response
      };
      const dialogRef = this.dialog.open(FactsDialogComponent, {
        data: data
      });
    });
  }

}
