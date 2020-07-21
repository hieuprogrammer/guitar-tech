import { TestBed } from '@angular/core/testing';

import { GuitarService } from './guitar.service';

describe('GuitarService', () => {
  let service: GuitarService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuitarService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
