import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatDialog } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatTabsModule } from '@angular/material/tabs';
import { RouterModule } from '@angular/router';
import { Artist } from 'src/app/models/Artist';
import { ArtistService } from 'src/app/services/artist/artist.service';
import { FactsDialogComponent } from '../facts-dialog/facts-dialog.component';
import { FactsService } from 'src/app/services/facts/facts.service';

@Component({
  selector: 'app-artist',
  templateUrl: './artist.component.html',
  styleUrls: ['./artist.component.css'],
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatIconModule, MatRadioModule, MatCardModule, FormsModule, RouterModule, MatTabsModule, CommonModule]
})
export class ArtistComponent {
  artists: Artist[] = [];

  constructor(private artistService: ArtistService, public dialog: MatDialog, private factsService: FactsService) {}

  ngOnInit() {
    const token = localStorage.getItem('token');
    this.artistService.getAllArtists(token!).subscribe((response) => {
      this.artists = response;
    })
  }


  openDialog(artistId: string) {
    const token = localStorage.getItem('token');
    this.factsService.getFactsAboutArtist(artistId, token!).subscribe((response) => {
      const data = {
        title: "an Artist",
        content: response
      };
      const dialogRef = this.dialog.open(FactsDialogComponent, {
        data: data
      });
    });
  }

}
