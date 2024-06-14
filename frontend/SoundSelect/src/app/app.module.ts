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
import { RecommendationsComponent } from './components/recommendations/recommendations.component';
import { MatTabsModule } from '@angular/material/tabs';
import { MusicUserComponent } from './components/music-user/music-user.component';
import { MusicArtistComponent } from './components/music-artist/music-artist.component';
import { SongComponent } from './components/song/song.component';
import { AlbumComponent } from './components/album/album.component';
import { ArtistComponent } from './components/artist/artist.component';
import { FactsDialogComponent } from './components/facts-dialog/facts-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MoodComponent } from './components/mood/mood.component';
import { MatSelectModule } from '@angular/material/select';
import { RatingDialogComponent } from './components/rating-dialog/rating-dialog.component';
import { FavoriteSongsComponent } from './components/favorite-songs/favorite-songs.component';

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
    ProfileArtistComponent,
    MatTabsModule,
    MusicUserComponent,
    MusicArtistComponent,
    RecommendationsComponent,
    SongComponent,
    FactsDialogComponent,
    MatDialogModule,
    AlbumComponent,
    ArtistComponent,
    MoodComponent,
    MatSelectModule,
    RatingDialogComponent,
    FavoriteSongsComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
