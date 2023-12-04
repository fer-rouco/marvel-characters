import { CanActivateFn, Router } from '@angular/router';
import { SessionService } from '../services/session.service';
import { inject } from '@angular/core';
import { Session } from '../model/session-interface';
import { StorageManagerService } from '../services/storage-manager.service';

export const AuthGuard: CanActivateFn = (route, state) => {
  const router: Router = inject(Router);
  const storageManagerService: StorageManagerService = inject(StorageManagerService);
  const session: Session | null = storageManagerService.getItem<Session>(SessionService.STORAGE_SESSION_IDENTIFIER);
  const loggedIn = Boolean(session && session.token); 

  if (!loggedIn) {
    router.navigateByUrl('/login');
  }

  return loggedIn;

};
