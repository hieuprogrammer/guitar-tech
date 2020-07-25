import { Component, OnInit } from '@angular/core';
import { Brand } from 'src/app/models/brand';
import { BrandService } from 'src/app/services/brand.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-brand-update',
  templateUrl: './brand-update.component.html',
  styleUrls: ['./brand-update.component.css']
})
export class BrandUpdateComponent implements OnInit {
  id: number;
  brand: Brand;

  constructor(
    private brandService: BrandService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getBrandById();
  }

  getBrandById() {
    this.id = this.route.snapshot.params.id;
    this.brand = new Brand();
    this.brandService.getBrandById(this.id).subscribe(data => this.brand = data);
  }

  updateBrand() {
    this.brandService.putBrand(this.id, this.brand).subscribe(data => this.router.navigate(['brands']));
  }
}
