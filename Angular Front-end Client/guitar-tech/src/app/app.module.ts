import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SignupComponent } from './components/signup/signup.component';
import { SigninComponent } from './components/signin/signin.component';
import { FormsModule } from '@angular/forms';
import { ContactComponent } from './components/contact/contact.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { GuitarComponent } from './components/guitar/master/guitar.component';
import { BrandComponent } from './components/brand/master/brand.component';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { GuitarDetailsComponent } from './components/guitar/details/guitar-details/guitar-details.component';
import { BrandDetailsComponent } from './components/brand/details/brand-details/brand-details.component';
import { BrandCreateComponent } from './components/brand/create/brand-create/brand-create.component';
import { BrandUpdateComponent } from './components/brand/update/brand-update/brand-update.component';
import { GuitarUpdateComponent } from './components/guitar/update/guitar-update/guitar-update.component';
import { GuitarCreateComponent } from './components/guitar/create/guitar-create/guitar-create.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    SigninComponent,
    GuitarComponent,
    BrandComponent,
    ContactComponent,
    HomeComponent,
    AboutComponent,
    NavbarComponent,
    FooterComponent,
    GuitarDetailsComponent,
    BrandDetailsComponent,
    BrandCreateComponent,
    BrandUpdateComponent,
    GuitarUpdateComponent,
    GuitarCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
