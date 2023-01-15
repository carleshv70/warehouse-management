import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WarehousesComponent } from './warehouses/warehouses.component';

const routes: Routes = [ 
  { path: '', redirectTo: '/warehouses', pathMatch: 'full' },
  { path: 'warehouses', component: WarehousesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
