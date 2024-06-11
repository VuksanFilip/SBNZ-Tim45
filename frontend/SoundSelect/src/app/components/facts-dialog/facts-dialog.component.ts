import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-facts-dialog',
  templateUrl: './facts-dialog.component.html',
  styleUrls: ['./facts-dialog.component.css'],
  standalone: true,
  imports: [RouterModule, CommonModule, MatDialogModule]
})
export class FactsDialogComponent {

}
