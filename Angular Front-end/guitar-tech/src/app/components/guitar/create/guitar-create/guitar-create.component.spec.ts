import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GuitarCreateComponent } from './guitar-create.component';

describe('GuitarCreateComponent', () => {
  let component: GuitarCreateComponent;
  let fixture: ComponentFixture<GuitarCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GuitarCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GuitarCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
