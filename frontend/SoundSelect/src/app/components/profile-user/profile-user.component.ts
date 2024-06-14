import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { RouterModule } from '@angular/router';
import { RegularUserService } from 'src/app/services/regular-user/regular-user.service';

@Component({
  selector: 'app-profile-user',
  templateUrl: './profile-user.component.html',
  styleUrls: ['./profile-user.component.css'],
  standalone: true,
  imports: [CommonModule, MatCardModule, FormsModule, RouterModule]
})
export class ProfileUserComponent implements OnInit {
  firstName: string = '';
  lastName: string = '';
  username: string = '';

  constructor(private regularUserService: RegularUserService) { }

  ngOnInit(): void {
    const token = localStorage.getItem('token');
    const id = localStorage.getItem('id');
    this.regularUserService.getRegularUser(id!, token!).subscribe((response) => {
      this.firstName = response.firstName;
      this.lastName = response.lastName;
      this.username = response.username;
    })
  }

}