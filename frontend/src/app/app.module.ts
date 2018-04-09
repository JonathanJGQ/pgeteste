import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { SelectiveComponent } from './formularios/selective/selective.component';
import { Tab } from './tabs/tab';
import { Tabs } from './tabs/tabs';
import { LocalComponent } from './formularios/local/local.component';
import { UsuarioComponent } from './formularios/usuario/novo_usuario/usuario.component';


@NgModule({
  declarations: [
    AppComponent,
    SelectiveComponent,
    Tab,
    Tabs,
    UsuarioComponent,
    LocalComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
