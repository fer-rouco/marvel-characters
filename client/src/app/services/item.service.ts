import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class ItemService extends BaseService {
  private url: string = '';

  public setUrl(url: string) {
    this.url = url;
  }

  protected getBaseUrl(): string {
    return this.url.replace(`${this.getUrlPrefix()}/`, '');
  }

  protected getUrlPrefix(): string {
    const protocol: string = "http://";
    return protocol.concat(this.url.replace(protocol, '').split('/')[0]);
  }

  public getDetailUrl(): Observable<string> {
    type Url = { type: string, url: string };
    type Result = { urls: Array<Url> };
    type Detail = { results: Array<Result> };

    return this.get<any>('').pipe(
      map((response: any) => {
        return response.data;
      }),
      map((data: Detail) => {
        return data.results[0].urls.filter((url: Url) => url.type === 'detail')[0].url;
      })
    );
  }
}


