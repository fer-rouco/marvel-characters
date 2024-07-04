import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { ApplicationConfig } from '@angular/core';
import { provideRouter, withHashLocation } from '@angular/router';

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes, withHashLocation()),  // Enable hash location strategy
    { provide: LocationStrategy, useClass: HashLocationStrategy }
  ]
};
