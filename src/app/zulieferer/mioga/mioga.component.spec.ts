import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiogaComponent } from './mioga.component';

describe('MiogaComponent', () => {
  let component: MiogaComponent;
  let fixture: ComponentFixture<MiogaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MiogaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MiogaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
