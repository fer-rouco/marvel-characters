import { Component, Input } from '@angular/core';
import { MarvelItem } from '../../../../model/character-interfaces';

@Component({
  selector: 'item',
  standalone: true,
  imports: [ItemComponent],
  templateUrl: './item.component.html',
  styleUrl: './item.component.scss'
})
export class ItemComponent {
  @Input() public item: MarvelItem | undefined = undefined;
}
