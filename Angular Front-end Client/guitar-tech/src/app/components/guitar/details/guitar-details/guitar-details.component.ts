import { ActivatedRoute } from '@angular/router';
import { Guitar } from './../../../../models/guitar';
import { Component, OnInit } from '@angular/core';
import { GuitarService } from 'src/app/services/guitar.service';

@Component({
  selector: 'app-guitar-details',
  templateUrl: './guitar-details.component.html',
  styleUrls: ['./guitar-details.component.css']
})
export class GuitarDetailsComponent implements OnInit {
  id: number;
  guitar: Guitar;

  constructor(
    private guitarService: GuitarService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.getGuitarById();
  }

  getGuitarById() {
    this.id = this.route.snapshot.params.id;
    this.guitar = new Guitar();
    this.guitarService.getGuitarById(this.id).subscribe(data => this.guitar = data);
  }
}
