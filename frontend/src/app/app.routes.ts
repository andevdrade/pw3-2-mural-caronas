import { Routes } from '@angular/router';
import { ListaCaronasComponent } from './pages/lista-caronas/lista-caronas';
import { CaronaFormComponent } from './pages/carona-form/carona-form.component';
export const routes: Routes = [
  { path: '', component: ListaCaronasComponent },
  { path: 'novo', component: CaronaFormComponent },
  { path: 'editar/:id', component: CaronaFormComponent }
];