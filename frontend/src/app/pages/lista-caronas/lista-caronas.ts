import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { CaronaService } from '../../core/services/carona.service';
import { Carona } from '../../core/models/carona';

@Component({
  selector: 'app-lista-caronas',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './lista-caronas.html',
  styleUrl: './lista-caronas.css'
})
export class ListaCaronasComponent implements OnInit {
  private caronaService = inject(CaronaService);
  caronas: Carona[] = [];

  ngOnInit(): void {
    this.carregarCaronas();
  }

  carregarCaronas(): void {
    this.caronaService.listarTodas().subscribe(dados => this.caronas = dados);
  }

  reservar(id: number): void {
    this.caronaService.reservarVaga(id).subscribe(() => this.carregarCaronas());
  }

  excluir(id: number): void {
    this.caronaService.deletar(id).subscribe(() => this.carregarCaronas());
  }
}