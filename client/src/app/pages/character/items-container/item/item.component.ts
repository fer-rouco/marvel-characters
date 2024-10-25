import { Component, Input } from '@angular/core';
import { RouterLink } from '@angular/router';
import { MarvelItem } from '../../../../model/character-interfaces';

@Component({
  selector: 'item',
  standalone: true,
  imports: [ItemComponent, RouterLink],
  templateUrl: './item.component.html',
  styleUrl: './item.component.scss'
})
export class ItemComponent {
  @Input() public item: MarvelItem | undefined = undefined;
}
