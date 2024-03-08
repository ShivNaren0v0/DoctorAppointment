import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddaAccountComponent } from './adda-account.component';

describe('AddaAccountComponent', () => {
  let component: AddaAccountComponent;
  let fixture: ComponentFixture<AddaAccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddaAccountComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddaAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
