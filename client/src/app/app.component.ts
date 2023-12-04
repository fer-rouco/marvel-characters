import { Component, Inject, WritableSignal, signal, OnInit } from '@angular/core';
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
export class AppComponent implements OnInit {
  public userName: WritableSignal<string> = signal('');

  constructor(protected sessionService: SessionService, @Inject(Router) protected router: Router) {}
  ngOnInit(): void {
    this.userName.set(this.getCurrentUser());
  }

  doLogout(): void {
    this.sessionService.logOut();
    this.router.navigateByUrl('/login');
  }

  getCurrentUser(): string {
    return this.sessionService.getCurrentUserName();
  }

  isAuthenticatedUser(): boolean {
    return this.sessionService.isAuthenticatedUser();
  }

}
