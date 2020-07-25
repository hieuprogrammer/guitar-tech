import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Brand } from '../models/brand';
import { API_URL, BRANDS_URL } from '../utils/app.constants';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(private httpClient: HttpClient) { }

  postBrand(brand: Brand) {
    return this.httpClient.post(`${BRANDS_URL}`, brand);
  }

  putBrand(id: number, brand: Brand) {
    return this.httpClient.put(`${BRANDS_URL}/${id}`, brand);
  }

  getBrands() {
    return this.httpClient.get<Brand[]>(`${API_URL}/brands`);
  }

  getBrandById(id: number) {
    return this.httpClient.get<Brand>(`${BRANDS_URL}/${id}`);
  }

  deleteBrandById(id: number) {
    return this.httpClient.delete(`${BRANDS_URL}/${id}`);
  }
}
