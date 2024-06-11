import { CommonModule } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-facts-dialog',
  templateUrl: './facts-dialog.component.html',
  styleUrls: ['./facts-dialog.component.css'],
  standalone: true,
  imports: [RouterModule, MatDialogModule, CommonModule]
})
export class FactsDialogComponent {
  constructor(
    public dialogRef: MatDialogRef<FactsDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}
}
