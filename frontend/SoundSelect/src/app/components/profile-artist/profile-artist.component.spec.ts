import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileArtistComponent } from './profile-artist.component';

describe('ProfileArtistComponent', () => {
  let component: ProfileArtistComponent;
  let fixture: ComponentFixture<ProfileArtistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProfileArtistComponent]
    });
    fixture = TestBed.createComponent(ProfileArtistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
