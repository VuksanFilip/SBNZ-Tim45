import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { ProfileUserComponent } from './components/profile-user/profile-user.component';
import { ProfileArtistComponent } from './components/profile-artist/profile-artist.component';

const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "registration", component: RegistrationComponent},
  {path: "profile-user", component: ProfileUserComponent},
  {path: "profile-artist", component: ProfileArtistComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
