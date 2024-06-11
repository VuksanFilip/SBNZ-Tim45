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
import { Recommendation } from 'src/app/models/Recommendation';
import { RegularUserService } from 'src/app/services/regular-user/regular-user.service';

@Component({
  selector: 'app-recommendations',
  templateUrl: './recommendations.component.html',
  styleUrls: ['./recommendations.component.css'],
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatIconModule, MatRadioModule, MatCardModule, FormsModule, RouterModule, MatTabsModule, CommonModule]
})
export class RecommendationsComponent implements OnInit {
  recommendations: Recommendation[] = [];

  constructor(private userService: RegularUserService) {}

  ngOnInit() {
    const token = localStorage.getItem('token');
    const userId = localStorage.getItem('id');
    this.userService.getUserRecommendations(userId!, token!).subscribe((response) => {
      this.recommendations = response;
      console.log(response);
    })
  }

}
