import { Component, Input } from '@angular/core';
import { MarvelItemsContainer } from '../../../model/character-interfaces';
import { FrameworkModule } from '../../../framework/framework.module';
import { ItemComponent } from './item/item.component';

@Component({
  selector: 'items-container',
  standalone: true,
  imports: [FrameworkModule, ItemComponent],
  templateUrl: './items-container.component.html',
  styleUrl: './items-container.component.scss'
})
export class ItemsContainerComponent {
  @Input() public title: string = '';
  @Input() public container: MarvelItemsContainer | undefined = undefined;

}
