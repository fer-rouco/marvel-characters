import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export abstract class BaseApiService extends BaseService {

  protected getUrlPrefix(): string {
    return `${environment.apiUrl}`;
  }

}
