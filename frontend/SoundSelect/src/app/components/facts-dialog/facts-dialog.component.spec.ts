import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FactsDialogComponent } from './facts-dialog.component';

describe('FactsDialogComponent', () => {
  let component: FactsDialogComponent;
  let fixture: ComponentFixture<FactsDialogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FactsDialogComponent]
    });
    fixture = TestBed.createComponent(FactsDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
