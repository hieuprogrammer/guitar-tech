import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Guitar } from '../models/guitar';
import { API_URL, GUITARS_URL } from '../utils/app.constants';

@Injectable({
  providedIn: 'root'
})
export class GuitarService {

  constructor(private httpClient: HttpClient) { }

  postGuitar(guitar: Guitar) {
    return this.httpClient.post(`${GUITARS_URL}`, guitar);
  }

  putGuitar(id: number, guitar: Guitar) {
    return this.httpClient.put(`${GUITARS_URL}/${id}`, guitar);
  }

  getGuitars() {
    return this.httpClient.get<Guitar[]>(`${API_URL}/guitars`);
  }

  getGuitarById(id: number) {
    return this.httpClient.get<Guitar>(`${GUITARS_URL}/${id}`);
  }

  deleteGuitarById(id: number) {
    return this.httpClient.delete(`${GUITARS_URL}/${id}`);
  }
}
