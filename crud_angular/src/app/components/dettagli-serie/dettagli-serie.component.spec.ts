import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettagliSerieComponent } from './dettagli-serie.component';

describe('DettagliSerieComponent', () => {
  let component: DettagliSerieComponent;
  let fixture: ComponentFixture<DettagliSerieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DettagliSerieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DettagliSerieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
