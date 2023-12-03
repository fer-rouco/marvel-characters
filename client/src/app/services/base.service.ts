import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import type { Observable} from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export abstract class BaseService {

  constructor(protected http: HttpClient) {}

  protected abstract getBaseUrl(): string;

  private buildUrl(urlPrefix: string): string {
    return `${environment.apiUrl}/${this.getBaseUrl()}${urlPrefix || ''}`;
  }

  get<T>(urlPrefix: string): Observable<T> {
    return this.http.get<T>(this.buildUrl(urlPrefix));
  }

  post<T>(urlPrefix: string, data: any): Observable<T> {
    return this.http.post<T>(this.buildUrl(urlPrefix), data);
  }
}
