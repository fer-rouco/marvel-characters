import { Routes } from '@angular/router';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';

export const routes: Routes = [
    { path: '', redirectTo: '/character-list', pathMatch: 'full' },
    {
      path: 'character-list',
      loadComponent: () => import('./pages/character-list/character-list.component').then((m) => m.CharacterListComponent)
    },
    {
      path: 'character/:id',
      loadComponent: () => import('./pages/character/character.component').then((m) => m.CharacterComponent)
    },
    {
      path: 'character-event-list',
      loadComponent: () => import('./pages/character-event-list/character-event-list.component').then((m) => m.CharacterEventListComponent)
    },
    { path: '**', component: PageNotFoundComponent }
  ];
