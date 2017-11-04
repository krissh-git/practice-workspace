import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrentTechStackComponent } from './current-tech-stack.component';

describe('CurrentTechStackComponent', () => {
  let component: CurrentTechStackComponent;
  let fixture: ComponentFixture<CurrentTechStackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CurrentTechStackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CurrentTechStackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
