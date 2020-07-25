import { GuitarUpdateComponent } from './components/guitar/update/guitar-update/guitar-update.component';
import { GuitarCreateComponent } from './components/guitar/create/guitar-create/guitar-create.component';
import { BrandUpdateComponent } from './components/brand/update/brand-update/brand-update.component';
import { BrandCreateComponent } from './components/brand/create/brand-create/brand-create.component';
import { GuitarDetailsComponent } from './components/guitar/details/guitar-details/guitar-details.component';
import { BrandDetailsComponent } from './components/brand/details/brand-details/brand-details.component';
import { AboutComponent } from './components/about/about.component';
import { HomeComponent } from './components/home/home.component';
import { ContactComponent } from './components/contact/contact.component';
import { SignupComponent } from './components/signup/signup.component';
import { SigninComponent } from './components/signin/signin.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GuitarComponent } from './components/guitar/master/guitar.component';
import { BrandComponent } from './components/brand/master/brand.component';


const routes: Routes = [
  { path: '', component: GuitarComponent },
  { path: 'sign-in', component: SigninComponent },
  { path: 'sign-up', component: SignupComponent },
  { path: 'home/:username', component: HomeComponent },
  { path: 'brands', component: BrandComponent },
  { path: 'brands/:id', component: BrandDetailsComponent },
  { path: 'create-brand', component: BrandCreateComponent },
  { path: 'update-brand/:id', component: BrandUpdateComponent },
  { path: 'guitars', component: GuitarComponent },
  { path: 'guitars/:id', component: GuitarDetailsComponent },
  { path: 'create-guitar', component: GuitarCreateComponent },
  { path: 'update-guitar/:id', component: GuitarUpdateComponent },
  { path: 'about', component: AboutComponent },
  { path: 'contact', component: ContactComponent },
  { path: '**', component: ContactComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
