import { BrandService } from './../../../services/brand.service';
import { GuitarService } from './../../../services/guitar.service';
import { Component, OnInit } from '@angular/core';
import { Guitar } from 'src/app/models/guitar';
import { Router } from '@angular/router';
import { Brand } from 'src/app/models/brand';

@Component({
  selector: 'app-guitar',
  templateUrl: './guitar.component.html',
  styleUrls: ['./guitar.component.css']
})
export class GuitarComponent implements OnInit {
  guitars: Guitar[];
  brands: Brand[];

  constructor(
    private brandService: BrandService,
    private guitarService: GuitarService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getGuitars();

    this.brandService.getBrands().subscribe(data => this.brands = data);
  }

  addGuitar() {
    this.router.navigate(['create-guitar']);
  }

  updateGuitar(id: number) {
    this.router.navigate(['update-guitar', id]);
  }

  getGuitars() {
    this.guitarService.getGuitars().subscribe(response => {
      console.log(response);
      this.guitars = response;
    });
  }

  getGuitarById(id: number) {
    this.router.navigate(['guitars', id]);
  }

  deleteGuitar(id: number) {
    this.guitarService.deleteGuitarById(id).subscribe(response => this.getGuitars());
  }
}
