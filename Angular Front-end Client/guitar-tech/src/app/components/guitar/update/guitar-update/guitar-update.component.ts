import { GuitarService } from 'src/app/services/guitar.service';
import { Component, OnInit } from '@angular/core';
import { Guitar } from 'src/app/models/guitar';
import { Brand } from 'src/app/models/brand';
import { BrandService } from 'src/app/services/brand.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-guitar-update',
  templateUrl: './guitar-update.component.html',
  styleUrls: ['./guitar-update.component.css']
})
export class GuitarUpdateComponent implements OnInit {
  id: number;
  guitar: Guitar;
  brands: Brand[];

  constructor(
    private guitarService: GuitarService,
    private brandService: BrandService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getGuitarById();

    this.brandService.getBrands().subscribe(data => this.brands = data);
  }

  getGuitarById() {
    this.id = this.route.snapshot.params.id;
    this.guitar = new Guitar();
    this.guitarService.getGuitarById(this.id).subscribe(data => this.guitar = data);
  }

  updateGuitar() {
    this.guitarService.putGuitar(this.id, this.guitar).subscribe(data => this.router.navigate(['guitars']));
  }

  handleFileInput(files: FileList) {
    const file = files.item(0);
    const reader = new FileReader();
    reader.readAsDataURL(file);

    reader.onload = () => {
      this.guitar.imageUrl = reader.result as string;
    };

    reader.onerror = () => {
      console.log('Unknown error(s) occured!');
    };
  }
}
