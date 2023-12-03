import { Component, Input } from '@angular/core';

export interface ColumnDefinition {
  attr: string;
  label: string;
  target?: (model: any) => string;
}

@Component({
  selector: 'custom-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
})
export class TableComponent {
  @Input() public columnDefinitions: ColumnDefinition[] = [];
  @Input() public rowObjects: any[] | undefined = undefined; // eslint-disable-line
}
