import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProfileUserComponent } from './components/profile-user/profile-user.component';
import { ProfileArtistComponent } from './components/profile-artist/profile-artist.component';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    LoginComponent,
    MatRadioModule,
    MatCardModule,
    RegistrationComponent,
    FormsModule,
    RouterModule,
    HttpClientModule,
    NavbarComponent,
    CommonModule,
    ProfileUserComponent,
    ProfileArtistComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
