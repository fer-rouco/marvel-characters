import { Component, inject, Input } from '@angular/core';
import { RouterLink } from '@angular/router';
import { MarvelItem } from '../../../../model/character-interfaces';
import { ItemService } from '../../../../services/item.service';

@Component({
  selector: 'item',
  standalone: true,
  imports: [ItemComponent, RouterLink],
  templateUrl: './item.component.html',
  styleUrl: './item.component.scss',
  providers: [ItemService]
})
export class ItemComponent {
  @Input() public item: MarvelItem | undefined = undefined;

  private itemService: ItemService = inject(ItemService);

  public isStory(): boolean {
    return this.item?.hasOwnProperty("type") || false;
  }

  public fetchItemDataFromResourceURI() {
    this.itemService.setUrl(this.item?.resourceURI || '');
    this.itemService.getDetailUrl().subscribe((url: string) => {
      window.open(url, "_blank");
    });
  }
}
