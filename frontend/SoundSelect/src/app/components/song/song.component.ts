import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatDialog } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatTabsModule } from '@angular/material/tabs';
import { RouterModule } from '@angular/router';
import { Song } from 'src/app/models/Song';
import { SongService } from 'src/app/services/song/song.service';
import { FactsDialogComponent } from '../facts-dialog/facts-dialog.component';
import { FactsService } from 'src/app/services/facts/facts.service';
import { RatingDialogComponent } from '../rating-dialog/rating-dialog.component';

@Component({
  selector: 'app-song',
  templateUrl: './song.component.html',
  styleUrls: ['./song.component.css'],
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatIconModule, MatRadioModule, MatCardModule, FormsModule, RouterModule, MatTabsModule, CommonModule]
})
export class SongComponent implements OnInit { 
  songs: Song[] = [];

  constructor(private songService: SongService, public dialog: MatDialog, private factsService: FactsService) {}

  ngOnInit() {
    const token = localStorage.getItem('token');
    this.songService.getAllSongs(token!).subscribe((response) => {
      this.songs = response;
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

  favorite(id: string) {
    const token = localStorage.getItem('token');
    const userId = localStorage.getItem('id');
    console.log("token" + token);
    console.log("user id" + userId);
    console.log("song id" + id);
    this.songService.favoriteSong(userId!, id, token!).subscribe((response) => {
      if (response.length != 0) {
        alert("You have new song recommendations! Check Recommendations tab.")
      } else {
        alert("This song is already in your favorites!");
      }
    })
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
