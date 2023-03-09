import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatCardModule} from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AddComponent } from './add/add.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { DettagliSerieComponent } from './components/dettagli-serie/dettagli-serie.component';
import { AppRoutingModule } from './app-routing.module';
import {MatFormFieldModule} from '@angular/material/form-field';
import { HomeComponent } from './components/home/home.component';
import { BypassSecurityPipe } from './bypass-security.pipe';
import { MatTabsModule} from '@angular/material/tabs';



@NgModule({
  declarations: [
    AppComponent,
    AddComponent,
    DettagliSerieComponent,
    HomeComponent,
    BypassSecurityPipe
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule,ReactiveFormsModule, BrowserAnimationsModule, MatCardModule, MatGridListModule, MatButtonModule, MatIconModule, AppRoutingModule, MatFormFieldModule, MatTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
