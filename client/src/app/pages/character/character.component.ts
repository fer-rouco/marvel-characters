import { Component, WritableSignal, signal } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { MarvelApiResponse, MarvelCharacter, MarvelItemsContainer, MarvelThumbnail, MarvelUrl } from '../../model/character-interfaces';
import { CharactersService } from '../../services/characters.service';
import { map, mergeMap, tap } from 'rxjs';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { FrameworkModule } from '../../framework/framework.module';
import { ItemsContainerComponent } from './items-container/items-container.component';

type MarvelItemsContainerWithTitle = { title: string } & { container: MarvelItemsContainer};

enum LinkEnum {
  DETAIL = 'detail',
  WIKI = 'wiki',
  COMIC_LINK = 'comiclink'
}

@Component({
  selector: 'character',
  standalone: true,
  imports: [FrameworkModule, HttpClientModule, ItemsContainerComponent],
  templateUrl: './character.component.html',
  styleUrl: './character.component.scss'
})
export class CharacterComponent {
  public title: WritableSignal<string> = signal('');
  public character: WritableSignal<MarvelCharacter | undefined> = signal(undefined);
  public marvelThumbnail: WritableSignal<MarvelThumbnail | undefined> = signal(undefined);
  public itemsContainer: WritableSignal<MarvelItemsContainerWithTitle[]> = signal([]);
  public marvelUrls: WritableSignal<MarvelUrl[]> = signal([]);

  constructor(
    private route: ActivatedRoute,
    protected charactersService: CharactersService
  ) {}
  
  ngOnInit(): void {
    this.route.paramMap.pipe(
      map((parameters: ParamMap) => parseInt(parameters.get('id') || '')),
      mergeMap((id: number) => this.charactersService.getById(id)),
      tap((response: MarvelApiResponse) => this.character.set(response?.data?.results[0])),
      tap(() => this.title.set(`Character ${this.character()?.name}`) ),
      tap(() => {
        const character: MarvelCharacter = this.character() as MarvelCharacter;
        if (character) {
          this.itemsContainer.set([
            { title: "Comics", container: character.comics },
            { title: "Stories", container: character.stories },
            { title: "Events", container: character.events },
            { title: "Series", container: character.series },
          ]);
          this.marvelUrls.set(character.urls);
          this.marvelThumbnail.set(character.thumbnail);
        }
      })
    ).subscribe();
  }

  mapTypeToLinkText(linkEnum: string): string {
    let linkText: string = '';
    
    switch (linkEnum) {
      case LinkEnum.DETAIL:
        linkText = 'Detail';
        break;
      case LinkEnum.WIKI:
        linkText = 'Wiki';
        break;
      case LinkEnum.COMIC_LINK:
        linkText = 'Comic Link';
        break;
    }

    return linkText;
  }

  buildThumbnailPath(thumbnail: MarvelThumbnail | undefined): string {
    return (thumbnail) ? `${thumbnail.path}/landscape_incredible.${thumbnail.extension}` : '';
  }
}
