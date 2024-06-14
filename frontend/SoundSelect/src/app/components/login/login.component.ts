import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from 'src/app/services/auth/auth.service';
import { AuthenticationRequest } from 'src/app/models/AuthenticationRequest';
import { jwtDecode }  from "jwt-decode";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatIconModule, MatRadioModule, MatCardModule, FormsModule, RouterModule]
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  hide = true;

  constructor(private authService: AuthService, private router: Router) { }

  clickEvent(event: MouseEvent) {
    this.hide = !this.hide;
    event.stopPropagation();
  }

  login() {
    const authenticationRequest: AuthenticationRequest = {
      username: this.username,
      password: this.password
    }

    this.authService.login(authenticationRequest).subscribe((response) => {
      alert("Successfully logged in!");
      const decoded: JwtPayload = jwtDecode(response.token);
      localStorage.setItem('username', decoded.sub);
      const role = decoded.role;
      localStorage.setItem('role', role);
      localStorage.setItem('id', decoded.id);
      localStorage.setItem('token', response.token);
      console.log(decoded.role);
      if (role == 'REGULAR_USER'){
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
          window.location.reload();
        });
        this.router.navigate(['profile-user']);
      }
      if (role == 'ARTIST'){
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
          window.location.reload();
        });
        this.router.navigate(['profile-artist']);
      }
    })
  }

}

export interface JwtPayload {
  sub: string;
  role: string;
  id: string;
  exp: number;
  iat: number;
}