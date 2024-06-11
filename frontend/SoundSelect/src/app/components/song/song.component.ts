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

@Component({
  selector: 'app-song',
  templateUrl: './song.component.html',
  styleUrls: ['./song.component.css'],
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatIconModule, MatRadioModule, MatCardModule, FormsModule, RouterModule, MatTabsModule, CommonModule]
})
export class SongComponent implements OnInit { 
  songs: Song[] = [];

  constructor(private songService: SongService, public dialog: MatDialog) {}

  ngOnInit() {
    const token = localStorage.getItem('token');
    this.songService.getAllSongs(token!).subscribe((response) => {
      this.songs = response;
    })
  }

  listen(id: string) {

  }

  rate(id: string) {
    
  }

  favorite(id: string) {
    
  }

  openDialog() {
    this.dialog.open(FactsDialogComponent);
  }
  
}
