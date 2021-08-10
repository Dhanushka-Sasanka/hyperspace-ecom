import { Category } from './../model/category';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private host: string = environment.baseURL;

  constructor(private http: HttpClient) { }

  public getUserAllAdvertisements(): Observable< Category[] | HttpErrorResponse> {
    return this.http.get<Category[]>(`${this.host}/api/category`);
  }
}
