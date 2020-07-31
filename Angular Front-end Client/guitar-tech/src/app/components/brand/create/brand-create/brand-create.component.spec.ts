import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BrandCreateComponent } from './brand-create.component';

describe('BrandCreateComponent', () => {
  let component: BrandCreateComponent;
  let fixture: ComponentFixture<BrandCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BrandCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BrandCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
