import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmkComponent } from './emk.component';

describe('EmkComponent', () => {
  let component: EmkComponent;
  let fixture: ComponentFixture<EmkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmkComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
