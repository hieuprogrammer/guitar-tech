import { Component, OnInit } from '@angular/core';
import { Brand } from 'src/app/models/brand';
import { BrandService } from 'src/app/services/brand.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-brand',
  templateUrl: './brand.component.html',
  styleUrls: ['./brand.component.css']
})
export class BrandComponent implements OnInit {
  brands: Brand[];

  constructor(
    private brandService: BrandService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getBrands();
  }

  addBrand() {
    this.router.navigate(['create-brand']);
  }

  updateBrand(id: number) {
    this.router.navigate(['update-brand', id]);
  }

  getBrands() {
    this.brandService.getBrands().subscribe(response => {
      console.log(response);
      this.brands = response;
    });
  }

  getBrandById(id: number) {
    this.router.navigate(['brands', id]);
  }

  deleteBrand(id: number) {
    this.brandService.deleteBrandById(id).subscribe(response => this.getBrands());
  }
}
