import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Guitar } from '../models/guitar';
import { API_URL } from '../utils/app.constants';

@Injectable({
  providedIn: 'root'
})
export class GuitarService {

  constructor(private httpClient: HttpClient) { }

  getGuitars() {
    return this.httpClient.get<Guitar[]>(`${API_URL}/guitars`);
  }

  getGuitar(guitarId) {
    return this.httpClient.get<Guitar>(`${API_URL}/guitars/${guitarId}`);
  }
}
