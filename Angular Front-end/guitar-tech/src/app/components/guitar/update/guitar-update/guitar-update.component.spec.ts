import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GuitarUpdateComponent } from './guitar-update.component';

describe('GuitarUpdateComponent', () => {
  let component: GuitarUpdateComponent;
  let fixture: ComponentFixture<GuitarUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GuitarUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GuitarUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
