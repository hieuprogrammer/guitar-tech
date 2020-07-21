import { GuitarService } from './../../../services/guitar.service';
import { Component, OnInit } from '@angular/core';
import { Guitar } from 'src/app/models/guitar';

@Component({
  selector: 'app-guitar',
  templateUrl: './guitar.component.html',
  styleUrls: ['./guitar.component.css']
})
export class GuitarComponent implements OnInit {
  guitars: Guitar[];

  constructor(private guitarService: GuitarService) { }

  ngOnInit(): void {
    this.getGuitars();
  }

  getGuitars() {
    this.guitarService.getGuitars().subscribe(response => {
      console.log(response);
      this.guitars = response;
    });
  }

}
