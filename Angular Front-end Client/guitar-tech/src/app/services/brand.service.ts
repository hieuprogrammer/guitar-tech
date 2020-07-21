import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Brand } from '../models/brand';
import { API_URL } from '../utils/app.constants';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(private httpClient: HttpClient) { }

  getBrands() {
    return this.httpClient.get<Brand[]>(`${API_URL}/brands`);
  }
}
