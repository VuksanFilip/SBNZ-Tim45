import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatTabsModule } from '@angular/material/tabs';
import { RouterModule } from '@angular/router';
import { SongComponent } from '../song/song.component';
import { AlbumComponent } from '../album/album.component';
import { ArtistComponent } from '../artist/artist.component';

@Component({
  selector: 'app-music-user',
  templateUrl: './music-user.component.html',
  styleUrls: ['./music-user.component.css'],
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatIconModule, MatRadioModule, MatCardModule, FormsModule, RouterModule, MatTabsModule, SongComponent, AlbumComponent, ArtistComponent]
})
export class MusicUserComponent {
  findNewMusic() {

  }

}
