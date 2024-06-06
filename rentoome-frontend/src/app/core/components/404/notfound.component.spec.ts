import { ComponentFixture, TestBed } from '@angular/core/testing';

import { notfoundComponent } from './notfound.component';

describe('notfoundComponent', () => {
  let component: notfoundComponent;
  let fixture: ComponentFixture<notfoundComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [notfoundComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(notfoundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
