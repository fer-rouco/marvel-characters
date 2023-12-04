import { Component, Inject, OnInit, WritableSignal, signal } from '@angular/core';
import { FrameworkModule } from '../../framework/framework.module';
import { HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { SessionService } from '../../services/session.service';
import { Router } from '@angular/router';

@Component({
  selector: 'login',
  standalone: true,
  imports: [FrameworkModule, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit {
  public model: WritableSignal<LoginModel> = signal(new LoginModel());
  public errorMessage: WritableSignal<string> = signal('');

  constructor(protected sessionService: SessionService, @Inject(Router) protected router: Router) {}

  ngOnInit(): void {
  }

  doLogin(): void {
    let model: LoginModel = this.model();
    this.sessionService.logIn(model.user, model.password).subscribe(() => {
      this.router.navigateByUrl('/character-list');
    }, (response: HttpErrorResponse) => {
      if (response.status === 401) {
        this.errorMessage.set("Contraseña incorrecta.");
      }
      if (response.status === 404) {
        this.errorMessage.set("Usuario no encontrado.");
      }
    });
  }
}

class LoginModel {
  public user: string = '';
  public password: string = '';
}