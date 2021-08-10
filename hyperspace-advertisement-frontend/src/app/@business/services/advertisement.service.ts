import { Adveretisement } from './../model/adveretisement';
import { environment } from '../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdvertisementService {

  private host: string = environment.baseURL;

  constructor(private http: HttpClient) { }

  public getUserAllAdvertisements(): Observable< Adveretisement[] | HttpErrorResponse> {
    return this.http.get<Adveretisement[]>(`${this.host}/api/ads`);
  }

  public getUserAllAdvertisementByUserID(userID:any): Observable< Adveretisement[] | HttpErrorResponse> {
    return this.http.get<Adveretisement[]>(`${this.host}/api/ads`,{params:{'userID': userID}});
  }

  public createUserAdvertisement(advertisement: Adveretisement): Observable< HttpResponse<any> | HttpErrorResponse> {
    return this.http.post< HttpResponse<any> | HttpErrorResponse>(`${this.host}/api/ads`,advertisement);
  }
}
