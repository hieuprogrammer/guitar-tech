import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Brand } from '../models/brand';
import { API_URL_V1, API_URL_V2, BRANDS_URL_V2, BRANDS_URL_V1 } from '../utils/app.constants';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(private httpClient: HttpClient) { }

  postBrand(brand: Brand) {
    return this.httpClient.post(`${BRANDS_URL_V2}`, brand);
  }

  putBrand(id: number, brand: Brand) {
    return this.httpClient.put(`${BRANDS_URL_V2}/${id}`, brand);
  }

  getBrands() {
    return this.httpClient.get<Brand[]>(`${API_URL_V2}/brands`);
  }

  getBrandById(id: number) {
    return this.httpClient.get<Brand>(`${BRANDS_URL_V2}/${id}`);
  }

  deleteBrandById(id: number) {
    return this.httpClient.delete(`${BRANDS_URL_V2}/${id}`);
  }
}
