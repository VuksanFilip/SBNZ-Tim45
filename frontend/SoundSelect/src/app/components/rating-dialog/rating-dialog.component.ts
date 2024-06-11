import { CommonModule } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { RouterModule } from '@angular/router';
import { Rating } from 'src/app/models/Rating';
import { SongService } from 'src/app/services/song/song.service';

@Component({
  selector: 'app-rating-dialog',
  templateUrl: './rating-dialog.component.html',
  styleUrls: ['./rating-dialog.component.css'],
  standalone: true,
  imports: [MatSelectModule, MatDialogModule, CommonModule, MatFormFieldModule, MatInputModule, MatIconModule, MatRadioModule, MatCardModule, FormsModule, RouterModule]
})
export class RatingDialogComponent {
  rating: Rating = {
    ratedById: '',
    songId: '',
    rating: '',
    comment: ''
  }

  constructor(
    private songService: SongService,
    public dialogRef: MatDialogRef<RatingDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  addRating(id: string) {
    const token = localStorage.getItem('token');
    const userId = localStorage.getItem('id');
    this.rating.ratedById = userId!;
    this.rating.songId = id;
    this.songService.rateSong(this.rating, token!).subscribe((response) => {
      if (response.length != 0) {
        alert("You have new song recommendations! Check Recommendations tab.")
      } else {
        alert("Successfully rated song!");
      }
      this.dialogRef.close();
    })
  }
}
