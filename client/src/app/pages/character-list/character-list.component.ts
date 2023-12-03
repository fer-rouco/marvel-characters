import { Component, OnInit, WritableSignal, signal } from '@angular/core';
import { FrameworkModule } from '../../framework/framework.module';
import { CharactersService } from '../../services/characters.service';
import { HttpClientModule } from '@angular/common/http';
import { MarvelApiResponse, MarvelCharacter, MarvelThumbnail } from '../../model/character-interfaces';
import { ColumnDefinition } from '../../framework/controls/table/table.component';

@Component({
  selector: 'character-list',
  standalone: true,
  imports: [FrameworkModule, HttpClientModule],
  templateUrl: './character-list.component.html',
  styleUrl: './character-list.component.scss',
  providers: [CharactersService]
})
export class CharacterListComponent implements OnInit {
  public columnDefinitions: Array<ColumnDefinition> = [];
  public characters: WritableSignal<MarvelCharacter[] | undefined> = signal(undefined);

  constructor(protected charactersService: CharactersService) {}

  ngOnInit(): void {
    this.columnDefinitions = [
      { attr: 'image', imgSrc: (model: MarvelCharacter) => this.buildThumbnailPath(model.thumbnail) },
      { attr: 'name', label: 'Name', target: (model: MarvelCharacter) => `/character/${model.id}` },
      { attr: 'description', label: 'Description' }
    ];

    this.charactersService.getAll().subscribe((response: MarvelApiResponse) => {
      console.log(response?.data?.results);
      this.characters.set(response?.data?.results);
    });
  }

  buildThumbnailPath(thumbnail: MarvelThumbnail | undefined): string {
    return (thumbnail) ? `${thumbnail.path}/standard_small.${thumbnail.extension}` : '';
  }
  
}
