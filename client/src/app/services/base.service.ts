import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import type { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export abstract class BaseService {

  constructor(protected http: HttpClient) {}

  protected abstract getBaseUrl(): string;
  
  protected abstract getUrlPrefix(): string;

  private buildUrl(urlPrefix: string): string {
    return `${this.getUrlPrefix()}/${this.getBaseUrl()}${urlPrefix || ''}`;
  }

  get<T>(urlPrefix: string, options?: any): Observable<T | HttpEvent<T>> {
    return this.http.get<T>(this.buildUrl(urlPrefix), options);
  }

  post<T>(urlPrefix: string, data?: any, options?: any): Observable<T | HttpEvent<T>> {
    return this.http.post<T>(this.buildUrl(urlPrefix), data, options);
  }
}
