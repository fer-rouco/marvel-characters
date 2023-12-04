import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';
import { FrameworkModule } from './framework/framework.module';
import { HttpClientModule } from '@angular/common/http';
import { SessionService } from './services/session.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, FrameworkModule, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  
  constructor(protected sessionService: SessionService, @Inject(Router) protected router: Router) {}

  doLogout(): void {
    this.sessionService.logOut().subscribe(() => {
      this.router.navigateByUrl('/login');
    });
  }

}
