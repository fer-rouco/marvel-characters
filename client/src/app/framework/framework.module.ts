import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { PanelComponent } from './containers/panel/panel.component';
import { BaseFieldComponent } from './controls/base-field.component';
import { CustomButtonComponent } from './controls/button/button.component';
import { FieldComponent } from './controls/fields/field/field.component';
import { InputFieldComponent } from './controls/fields/input-field/input-field.component';
import { NumericFieldComponent } from './controls/fields/numeric-field/numeric-field.component';
import { PasswordFieldComponent } from './controls/fields/password-field/password-field.component';
import { TextFieldComponent } from './controls/fields/text-field/text-field.component';
import { TableComponent } from './controls/table/table.component';
@NgModule({
  declarations: [
    PanelComponent,
    FieldComponent,
    BaseFieldComponent,
    InputFieldComponent,
    TextFieldComponent,
    PasswordFieldComponent,
    NumericFieldComponent,
    CustomButtonComponent,
    TableComponent
  ],
  exports: [
    PanelComponent,
    InputFieldComponent,
    TextFieldComponent,
    PasswordFieldComponent,
    NumericFieldComponent,
    CustomButtonComponent,
    TableComponent
  ],
  imports: [CommonModule, FormsModule, RouterLink],
})
export class FrameworkModule {}
