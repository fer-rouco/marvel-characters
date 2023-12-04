import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PanelComponent } from './containers/panel/panel.component';
import { InputFieldComponent } from './controls/fields/input-field/input-field.component';
import { FormsModule } from '@angular/forms';
import { FieldComponent } from './controls/fields/field/field.component';
import { NumericFieldComponent } from './controls/fields/numeric-field/numeric-field.component';
import { BaseFieldComponent } from './controls/base-field.component';
import { CustomButtonComponent } from './controls/button/button.component';
import { TableComponent } from './controls/table/table.component';
import { TextFieldComponent } from './controls/fields/text-field/text-field.component';
import { PasswordFieldComponent } from './controls/fields/password-field/password-field.component';
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
  imports: [CommonModule, FormsModule],
})
export class FrameworkModule {}
