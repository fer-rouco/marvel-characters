import { Injectable } from '@angular/core';
import { BaseService } from './base.service';
import { EventList } from '../model/event-list-interface';
import type { Observable} from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'any'
})
export class ServiceLogService extends BaseService {

  constructor(protected override http: HttpClient, private sessionService: SessionService) {
    super(http);
  }

  protected override getBaseUrl(): string {
    return 'service-log';
  }

  getAll(): Observable<EventList[]> {
    return this.get<EventList[]>(`/${this.sessionService.getCurrentUserName()}`) as Observable<EventList[]>;
  }

}
