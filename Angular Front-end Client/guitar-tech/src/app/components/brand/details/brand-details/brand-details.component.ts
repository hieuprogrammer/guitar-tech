import { BrandService } from 'src/app/services/brand.service';
import { Brand } from 'src/app/models/brand';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-brand-details',
  templateUrl: './brand-details.component.html',
  styleUrls: ['./brand-details.component.css']
})
export class BrandDetailsComponent implements OnInit {
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
}
