import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './/app-routing.module';
import { FormsModule } from '@angular/forms';



import { AppComponent } from './app.component';
import { SelectiveComponent } from './formularios/selective/selective.component';
import { Tab } from './tabs/tab';
import { Tabs } from './tabs/tabs';
import { LocalComponent } from './formularios/local/novo-local/local.component';
import { UsuarioComponent } from './formularios/usuario/novo_usuario/usuario.component';
import { ListarUsuarioComponent } from './formularios/usuario/listar-usuario/listar-usuario.component';
import { SelectiveService } from './services/selective.service';
import { HttpClient } from 'selenium-webdriver/http';
import { ListarLocalComponent } from './formularios/local/listar-local/listar-local.component';


@NgModule({
  declarations: [
    AppComponent,
    SelectiveComponent,
    Tab,
    Tabs,
    UsuarioComponent,
    ListarUsuarioComponent,
    LocalComponent,
    ListarLocalComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    SelectiveService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
