import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import jsSHA from 'jssha';
import { map, tap, type Observable } from 'rxjs';
import { Session } from '../model/session-interface';
import { BaseApiService } from './base-api.service';
import { StorageManagerService } from './storage-manager.service';

@Injectable({
  providedIn: 'any'
})
export class SessionService extends BaseApiService {

  constructor(protected override http: HttpClient, private sessionStorageService: StorageManagerService) {
    super(http);
  }
  
  static STORAGE_SESSION_IDENTIFIER: string = 'session';

  protected override getBaseUrl(): string {
    return "session";
  }
  
  logIn(user: string, password: string): Observable<Session> {
    const shaObj = new jsSHA('SHA-256', 'TEXT', { encoding: 'UTF8' });
    shaObj.update(password);
    const hashedPassword = shaObj.getHash('HEX');

    return this.get<Session>('/login', {
      params: { userName: user, password: hashedPassword },
    }).pipe(
      tap((session) => {
        this.sessionStorageService.setItem(SessionService.STORAGE_SESSION_IDENTIFIER, session);
        return session;
      }),
      map(() => this.sessionStorageService.getItem(SessionService.STORAGE_SESSION_IDENTIFIER) || <Session>{})
    );
  }

  logOut(): void {
    this.sessionStorageService.removeItem(SessionService.STORAGE_SESSION_IDENTIFIER);
  }

  getCurrentSession(): Session | null {
    return this.sessionStorageService.getItem<Session>(SessionService.STORAGE_SESSION_IDENTIFIER);
  }

  getCurrentUserName(): string {
    return this.getCurrentSession()?.userName || '';
  }

  isAuthenticatedUser(): boolean {
    let session: Session | null = this.getCurrentSession();
    return Boolean(session && session.token);
  }

}
