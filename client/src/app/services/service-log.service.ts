import { Injectable } from '@angular/core';
import { BaseService } from './base.service';
import { EventList } from '../model/event-list-interface';
import type { Observable} from 'rxjs';

@Injectable({
  providedIn: 'any'
})
export class ServiceLogService extends BaseService {
  
  protected override getBaseUrl(): string {
    return 'service-log';
  }

  getAll(): Observable<EventList[]> {
    return this.get<EventList[]>('') as Observable<EventList[]>;
  }

}
