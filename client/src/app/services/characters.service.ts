import { Injectable, Inject } from '@angular/core';
import type { Observable} from 'rxjs';
import { BaseService } from './base.service';
import { MarvelApiResponse } from '../model/character-interfaces';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'any'
})
export class CharactersService extends BaseService {

  protected getBaseUrl(): string {
    return "characters";
  }

  getAll(): Observable<MarvelApiResponse> {
    return this.get<MarvelApiResponse>('');
  }

  getById(id: number): Observable<MarvelApiResponse> {
    return this.get<MarvelApiResponse>(`/${id}`);
  }

}
