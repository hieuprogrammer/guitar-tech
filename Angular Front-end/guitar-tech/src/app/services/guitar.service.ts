import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Guitar } from '../models/guitar';
import { API_URL_V2, GUITARS_URL_V2 } from '../utils/app.constants';

@Injectable({
  providedIn: 'root'
})
export class GuitarService {

  constructor(private httpClient: HttpClient) { }

  postGuitar(guitar: Guitar) {
    return this.httpClient.post(`${GUITARS_URL_V2}`, guitar);
  }

  putGuitar(id: number, guitar: Guitar) {
    return this.httpClient.put(`${GUITARS_URL_V2}/${id}`, guitar);
  }

  getGuitars() {
    return this.httpClient.get<Guitar[]>(`${API_URL_V2}/guitars`);
  }

  getGuitarById(id: number) {
    return this.httpClient.get<Guitar>(`${GUITARS_URL_V2}/${id}`);
  }

  deleteGuitarById(id: number) {
    return this.httpClient.delete(`${GUITARS_URL_V2}/${id}`);
  }

  searchGuitar(keyword: string) {
    return this.httpClient.get<Guitar[]>(`${GUITARS_URL_V2}?search=${keyword}`);
  }
}
