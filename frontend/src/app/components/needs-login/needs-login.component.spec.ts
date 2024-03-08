import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeedsLoginComponent } from './needs-login.component';

describe('NeedsLoginComponent', () => {
  let component: NeedsLoginComponent;
  let fixture: ComponentFixture<NeedsLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NeedsLoginComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NeedsLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
