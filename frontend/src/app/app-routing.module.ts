import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { ListarUsuarioComponent } from './formularios/usuario/listar-usuario/listar-usuario.component';
import { ListarLocalComponent } from './formularios/local/listar-local/listar-local.component';
import { UsuarioComponent } from './formularios/usuario/novo_usuario/usuario.component';
import { LocalComponent } from './formularios/local/novo-local/local.component';

const routes: Routes = [
    { path: '', redirectTo: 'selective/1/users', pathMatch: 'full' },
    { path: 'selective/:id/users', component: ListarUsuarioComponent },
    { path: 'selective/:id/places', component: ListarLocalComponent },
    { path: 'selective/:id/users/new', component: UsuarioComponent },
    { path: 'selective/:id/places/new', component: LocalComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes) ],
    exports: [RouterModule]
})
export class AppRoutingModule { }