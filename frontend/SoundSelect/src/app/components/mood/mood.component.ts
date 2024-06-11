import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { RouterModule } from '@angular/router';
import { MatSelectModule } from '@angular/material/select';
import { UserMood } from 'src/app/models/UserMood';
import { User } from 'src/app/models/User';
import { CommonModule } from '@angular/common';
import { RecommendationService } from 'src/app/services/recommendation/recommendation.service';

@Component({
  selector: 'app-mood',
  templateUrl: './mood.component.html',
  styleUrls: ['./mood.component.css'],
  standalone: true,
  imports: [MatSelectModule, MatFormFieldModule, MatInputModule, MatIconModule, MatRadioModule, MatCardModule, FormsModule, RouterModule, CommonModule]
})
export class MoodComponent {
  userMood: UserMood = {
    currentMood: ''
  }

  constructor(private recommendationService: RecommendationService) {}

  getRecommendation() {
    const token = localStorage.getItem('token');
    const userId = localStorage.getItem('id');
    this.recommendationService.getRecommendationForMood(userId!, this.userMood, token!).subscribe((response) => {
      console.log(response);
    })
  }

}
