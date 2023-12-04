import { Component, Input } from '@angular/core';
import { BaseFieldComponent } from '../../base-field.component';

@Component({
  selector: 'password-field',
  templateUrl: './password-field.component.html',
  styleUrl: './password-field.component.scss'
})
export class PasswordFieldComponent extends BaseFieldComponent {
  @Input() public type: string = 'password';
}