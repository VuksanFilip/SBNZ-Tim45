import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { ProfileUserComponent } from './components/profile-user/profile-user.component';
import { ProfileArtistComponent } from './components/profile-artist/profile-artist.component';
import { MusicUserComponent } from './components/music-user/music-user.component';
import { MusicArtistComponent } from './components/music-artist/music-artist.component';
import { MoodComponent } from './components/mood/mood.component';
import { RecommendationsComponent } from './components/recommendations/recommendations.component';

const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "registration", component: RegistrationComponent},
  {path: "profile-user", component: ProfileUserComponent},
  {path: "profile-artist", component: ProfileArtistComponent},
  {path: "music-user", component: MusicUserComponent},
  {path: "music-artist", component: MusicArtistComponent},
  {path: "mood", component: MoodComponent},
  {path: "recommendations", component: RecommendationsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
