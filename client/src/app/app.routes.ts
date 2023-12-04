import { Routes } from '@angular/router';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { AuthGuard } from './guards/auth.guard';

export const routes: Routes = [
    { path: '', redirectTo: '/character-list', pathMatch: 'full' },
    {
      path: 'login',
      loadComponent: () => import('./pages/login/login.component').then((m) => m.LoginComponent)
    },
    {
      path: 'character-list',
      loadComponent: () => import('./pages/character-list/character-list.component').then((m) => m.CharacterListComponent),
      canActivate: [AuthGuard]
    },
    {
      path: 'character/:id',
      loadComponent: () => import('./pages/character/character.component').then((m) => m.CharacterComponent),
      canActivate: [AuthGuard]
    },
    {
      path: 'character-event-list',
      loadComponent: () => import('./pages/character-event-list/character-event-list.component').then((m) => m.CharacterEventListComponent),
      canActivate: [AuthGuard]
    },
    { path: '**', component: PageNotFoundComponent }
  ];
