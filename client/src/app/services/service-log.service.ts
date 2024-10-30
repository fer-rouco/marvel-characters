import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import type { Observable } from 'rxjs';
import { EventList } from '../model/event-list-interface';
import { BaseApiService } from './base-api.service';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'any'
})
export class ServiceLogService extends BaseApiService {

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
