import { GuitarService } from 'src/app/services/guitar.service';
import { Component, OnInit } from '@angular/core';
import { Guitar } from 'src/app/models/guitar';
import { Router } from '@angular/router';
import { BrandService } from 'src/app/services/brand.service';
import { Brand } from 'src/app/models/brand';

@Component({
  selector: 'app-guitar-create',
  templateUrl: './guitar-create.component.html',
  styleUrls: ['./guitar-create.component.css']
})
export class GuitarCreateComponent implements OnInit {
  guitar: Guitar;
  brands: Brand[];

  constructor(
    private brandService: BrandService,
    private guitarService: GuitarService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.guitar = new Guitar();

    this.brandService.getBrands().subscribe(data => this.brands = data);
  }

  addGuitar() {
    this.guitarService.postGuitar(this.guitar).subscribe(data => this.router.navigate(['guitars']));
  }
}
