import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import type { Observable } from 'rxjs';
import { MarvelApiResponse } from '../model/character-interfaces';
import { BaseApiService } from './base-api.service';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'any'
})
export class CharactersService extends BaseApiService {

  constructor(protected override http: HttpClient, private sessionService: SessionService) {
    super(http);
  }

  protected getBaseUrl(): string {
    return "characters";
  }

  getAll(): Observable<MarvelApiResponse> {
    return this.get<MarvelApiResponse>(`/${this.sessionService.getCurrentUserName()}`) as Observable<MarvelApiResponse>;
  }

  getById(id: number): Observable<MarvelApiResponse> {
    return this.get<MarvelApiResponse>(`/${this.sessionService.getCurrentUserName()}/${id}`) as Observable<MarvelApiResponse>;
  }

}
