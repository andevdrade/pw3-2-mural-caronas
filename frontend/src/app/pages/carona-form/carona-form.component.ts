import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { CaronaService } from '../../core/services/carona.service';

@Component({
  selector: 'app-carona-form',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './carona-form.component.html',
  styleUrl: './carona-form.component.css'
})
export class CaronaFormComponent implements OnInit {
  private fb = inject(FormBuilder);
  private caronaService = inject(CaronaService);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  idCarona = Number(this.route.snapshot.paramMap.get('id'));

  form = this.fb.group({
    origem: ['', Validators.required],
    destino: ['', Validators.required],
    dataHora: ['', Validators.required],
    vagasDisponiveis: [1, [Validators.required, Validators.min(1)]]
  });

  ngOnInit(): void {
    if (this.idCarona) {
      this.caronaService.buscarPorId(this.idCarona).subscribe(carona => this.form.patchValue(carona));
    }
  }

  salvar(): void {
    if (this.form.invalid) return;

    const dados = this.form.value as any;
    const operacao = this.idCarona 
      ? this.caronaService.atualizar(this.idCarona, dados)
      : this.caronaService.criar(dados);

    operacao.subscribe(() => {
      this.router.navigate(['/']);
    });
  }
}