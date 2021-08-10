import { NotificationService } from './../../@business/services/notification.service';
import { AuthenticationService } from '../authentication.service';
import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { NotificationType } from 'src/app/@business/enum/notificaiton-type.enum';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private authenticationService: AuthenticationService,
    private notificationService: NotificationService) { }

  intercept(httpRequest: HttpRequest<any>, httpHandler: HttpHandler): Observable<HttpEvent<any>> {
    if (httpRequest.url.includes(`${this.authenticationService.host}/api/login`)) {
      return httpHandler.handle(httpRequest);
    }
    if (httpRequest.url.includes(`${this.authenticationService.host}/api/register`)) {
      return httpHandler.handle(httpRequest);
    }

    this.authenticationService.loadToken();
    const loadedToken = this.authenticationService.getToken();
    const request = httpRequest.clone({ setHeaders: { Authorization: `Bearer ${loadedToken}` } });

    //Sending notifications to user
    this.notificationService.notify(NotificationType.ERROR, "You need to log in to access this page.");
    return httpHandler.handle(request);
  }
}
