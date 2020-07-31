import { Router } from '@angular/router';
import { BrandService } from 'src/app/services/brand.service';
import { Component, OnInit } from '@angular/core';
import { Brand } from 'src/app/models/brand';

@Component({
  selector: 'app-brand-create',
  templateUrl: './brand-create.component.html',
  styleUrls: ['./brand-create.component.css']
})
export class BrandCreateComponent implements OnInit {
  brand: Brand;

  constructor(
    private brandService: BrandService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.brand = new Brand();
  }

  addBrand() {
    this.brandService.postBrand(this.brand).subscribe(data => this.router.navigate(['brands']));
  }
}
