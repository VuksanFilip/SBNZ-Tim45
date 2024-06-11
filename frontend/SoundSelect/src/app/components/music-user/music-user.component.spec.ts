import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicUserComponent } from './music-user.component';

describe('MusicUserComponent', () => {
  let component: MusicUserComponent;
  let fixture: ComponentFixture<MusicUserComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MusicUserComponent]
    });
    fixture = TestBed.createComponent(MusicUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
