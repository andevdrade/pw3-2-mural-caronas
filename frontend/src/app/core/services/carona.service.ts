import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Carona } from '../models/carona';

@Injectable({
  providedIn: 'root'
})
export class CaronaService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/caronas';

  listarTodas(): Observable<Carona[]> {
    return this.http.get<Carona[]>(this.apiUrl);
  }

  buscarPorId(id: Number): Observable<Carona> {
    return this.http.get<Carona>(`${this.apiUrl}/${id}`);
  }

  criar(carona: Carona): Observable<Carona> {
    return this.http.post<Carona>(this.apiUrl, carona);
  }

  atualizar(id: Number, carona: Carona): Observable<Carona> {
    return this.http.put<Carona>(`${this.apiUrl}/${id}`, carona);
  }

  deletar(id: Number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  reservarVaga(id: Number): Observable<Carona> {
    return this.http.post<Carona>(`${this.apiUrl}/${id}/reservar`, {});
  }
}