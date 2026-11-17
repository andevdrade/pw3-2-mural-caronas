import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaCaronasComponent } from './lista-caronas';

describe('ListaCaronas', () => {
  let component: ListaCaronasComponent;
  let fixture: ComponentFixture<ListaCaronasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaCaronasComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(ListaCaronasComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
