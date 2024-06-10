import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { RouterModule } from '@angular/router';
import { ArtistService } from 'src/app/services/artist/artist.service';

@Component({
  selector: 'app-profile-artist',
  templateUrl: './profile-artist.component.html',
  styleUrls: ['./profile-artist.component.css'],
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatIconModule, MatRadioModule, MatCardModule, FormsModule, RouterModule, CommonModule]
})
export class ProfileArtistComponent implements OnInit {
  firstName: string = '';
  lastName: string = '';
  username: string = '';
  genre: string = '';
  newGenre: string = '';

  constructor(private artistService: ArtistService) { }

  ngOnInit(): void {
    const token = localStorage.getItem('token');
    const id = localStorage.getItem('id');
    this.artistService.getArtist(id!, token!).subscribe((response) => {
      this.firstName = response.firstName;
      this.lastName = response.lastName;
      this.username = response.username;
    })

    this.artistService.getArtistGenre(id!, token!).subscribe((response) => {
      this.genre = response.genre;
    })
  }

  addGenre() {

  }

}