import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DettagliSerieComponent } from './components/dettagli-serie/dettagli-serie.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent, children: [] },
  { path: 'serie', redirectTo: '/home', pathMatch: 'full'},
  { path: 'serie', component: DettagliSerieComponent, children: [
    { path: ':id', component: DettagliSerieComponent}
  ] },
  { path: '**', redirectTo: '/'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }